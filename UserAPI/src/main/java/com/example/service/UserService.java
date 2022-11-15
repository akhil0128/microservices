package com.example.service;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.ContactDTO;
import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.exception.UserNotAvailableException;
import com.example.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RefreshScope
@Service
public class UserService {

	@Autowired
	UserRepository userrepo;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	DiscoveryClient client;
	@Value("${url}")
	String url;

	@CircuitBreaker(name = "UserAPI-service", fallbackMethod = "addUserfallback")
	public UserDTO addUserToRepo(UserDTO userDTO) {
		User user = userDTO.convertToEntity();
		Optional<User> findById = userrepo.findById(user.getId());
		if (findById.isPresent()) {
			throw new UserNotAvailableException("User with this user id is already available");
		}
		ContactDTO contactDTO = userDTO.getContactDTO();
		contactDTO.setUserid(userDTO.getId());
		// take all instances of contact-service from consul in the list
//		List<ServiceInstance> instances = client.getInstances("contact-service");
//		String uri = instances.get(0).getUri().toString();
//		String uri = "http://ContactAPI-service";
		ContactDTO addObject = restTemplate.postForObject(url + "/contact", contactDTO, ContactDTO.class);
		User userSaved = userrepo.save(user);
		UserDTO convertedDTO = userSaved.convertToDTO(user);
		convertedDTO.setContactDTO(addObject);
		return convertedDTO;
	}

	public UserDTO addUserfallback(UserDTO userDTO, Throwable throwable) {

		System.out.println("fallback");
		return new UserDTO();
		// return "Fallback method response: error occured in producer API";
	}

	@CircuitBreaker(name = "UserAPI-service", fallbackMethod = "getUserfallback")
	public UserDTO getUserDetailsFromDB(int id) {
		Optional<User> optionalUser = userrepo.findById(id);
		User user = optionalUser.orElseThrow(() -> new UserNotAvailableException("User does not exist"));
		ContactDTO contactDTO = new ContactDTO();
		contactDTO.setUserid(id);
		ContactDTO forObject = restTemplate.getForObject(url + "/getcontact/{id}", ContactDTO.class, id);
		UserDTO convertToDTO = user.convertToDTO(user);
		convertToDTO.setContactDTO(forObject);
		return convertToDTO;
	}
	
	public UserDTO getUserfallback(int id, Throwable throwable) {
		System.out.println("fallback");
		return new UserDTO();
	}
}
