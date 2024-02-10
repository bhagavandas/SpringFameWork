package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exceptions.ErrorResponse;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value = BookException.class)
	@ResponseStatus
	@ResponseBody
	public ErrorResponse handleUserExistsException(BookException e) {
		return new ErrorResponse(1, e.getMessage());
	}
	

	

}
