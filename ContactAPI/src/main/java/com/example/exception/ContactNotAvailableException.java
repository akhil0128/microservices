package com.example.exception;

public class ContactNotAvailableException extends RuntimeException {

	public ContactNotAvailableException(String message) {
		super(message);
	}
}
