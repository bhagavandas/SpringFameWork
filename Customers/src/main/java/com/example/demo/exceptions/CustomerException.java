package com.example.demo.exceptions;

public class CustomerException extends RuntimeException {

	private String message;

	public CustomerException(String message) {

		this.message = message;
	}

	public CustomerException() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
