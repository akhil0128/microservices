package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDTO;
import com.example.service.UserService;

@RestController
public class UserCotroller {

	@Autowired
	UserService userservice;

	@PostMapping("/user")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		UserDTO user = userservice.addUserToRepo(userDTO);
		return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/getuser/{id}")
	public UserDTO getUser(@PathVariable int id) {
		return userservice.getUserDetailsFromDB(id);
	}
}
