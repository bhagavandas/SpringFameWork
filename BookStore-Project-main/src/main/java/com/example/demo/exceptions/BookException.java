package com.example.demo.exceptions;

public class BookException extends RuntimeException {

	private String message;

	public BookException(String message) {

		this.message = message;
	}

	public BookException() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
