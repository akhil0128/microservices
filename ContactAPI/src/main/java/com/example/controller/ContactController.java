package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ContactDTO;
import com.example.entity.Contact;
import com.example.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService contservice;

	@PostMapping("/contact")
	public ResponseEntity<ContactDTO> addContact(@RequestBody ContactDTO contactDTO) {
		if (contactDTO.getUserid() == 119) {
			throw new RuntimeException();
		}
		ContactDTO contact = contservice.addContactToRepo(contactDTO);
		return new ResponseEntity<ContactDTO>(contact, HttpStatus.CREATED);
	}

	@GetMapping("/getcontact/{id}")
	public Contact getContact(@PathVariable int id) {
		if (id == 119) {
			throw new RuntimeException();
		}
		Contact receivedcontact = contservice.getContactDetails(id);
		return receivedcontact;
	}
}
