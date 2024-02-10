package com.example.demo.exceptions;

public class TradeException extends RuntimeException {

	private String message;

	public TradeException(String message) {

		this.message = message;
	}

	public TradeException() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
