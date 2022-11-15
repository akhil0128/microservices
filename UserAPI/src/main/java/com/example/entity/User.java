package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.dto.UserDTO;
@Entity
public class User {

	@Id
	private int id;
	private String fname;
	private String lname;
	
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
	public UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFname(user.getFname());
		userDTO.setLname(user.getLname());
		return userDTO;
	}
}
