package com.example.dto;

import com.example.entity.Contact;

public class ContactDTO {

	private int userid;
	private String email;
	private int phonenumber;
	private String city;
	private int pincode;
	private UserDTO userinfo;

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

	public UserDTO getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserDTO userinfo) {
		this.userinfo = userinfo;
	}

	public Contact convertToEntity() {

		Contact contact = new Contact();
		contact.setUserid(this.getUserid());
		contact.setEmail(this.getEmail());
		contact.setPhonenumber(this.getPhonenumber());
		contact.setCity(this.getCity());
		contact.setPincode(this.getPincode());
		return contact;
	}
}
