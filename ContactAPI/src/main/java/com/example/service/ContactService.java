package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ContactDTO;
import com.example.entity.Contact;
import com.example.exception.ContactNotAvailableException;
import com.example.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contrepo;

	public ContactDTO addContactToRepo(ContactDTO contactDTO) {
		Contact contact = contactDTO.convertToEntity();
		Contact save = contrepo.save(contact);
		ContactDTO contDTO = save.convertToDTO(contact);
		return contDTO;
	}

	public Contact getContactDetails(int id) {
		Optional<Contact> optionalContact = contrepo.findById(id);
		Contact contactDetailsFromDB = optionalContact
				.orElseThrow(() -> new ContactNotAvailableException("Contact details do not exist"));
		return contactDetailsFromDB;
	}
}
