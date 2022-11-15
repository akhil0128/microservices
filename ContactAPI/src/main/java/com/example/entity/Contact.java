package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.dto.ContactDTO;
import com.example.dto.UserDTO;

@Entity
public class Contact {

	@Id
	private int userid;
	private String email;
	private int phonenumber;
	private String city;
	private int pincode;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public ContactDTO convertToDTO(Contact contact) {

		ContactDTO contactDTO = new ContactDTO();
		contactDTO.setUserid(contact.getUserid());
		contactDTO.setEmail(contact.getEmail());
		contactDTO.setPhonenumber(contact.getPhonenumber());
		contactDTO.setCity(contact.getCity());
		contactDTO.setPincode(contact.getPincode());
		return contactDTO;
	}
}
