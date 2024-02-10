package com.example.demo.exceptions;

public class SlotAvailableException extends RuntimeException {

	private String message;

	public SlotAvailableException(String message) {

		this.message = message;
	}

	public SlotAvailableException() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
