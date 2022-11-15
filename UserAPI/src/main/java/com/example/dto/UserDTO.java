package com.example.dto;

import com.example.entity.User;

public class UserDTO {

	private int id;
	private String fname;
	private String lname;
	private ContactDTO contactDTO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public User convertToEntity() {
		User user=new User();
		user.setId(this.getId());
		user.setFname(this.getFname());
		user.setLname(this.getLname());
		return user;
	}
	public ContactDTO getContactDTO() {
		return contactDTO;
	}
	public void setContactDTO(ContactDTO contactDTO) {
		this.contactDTO = contactDTO;
	}
}
