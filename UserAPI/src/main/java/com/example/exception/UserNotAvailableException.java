package com.example.exception;

public class UserNotAvailableException extends RuntimeException {

	public UserNotAvailableException(String message) {
		super(message);
	}
}
