package com.voytenko.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Artem Voytenko
 * 31.01.2019
 */


@ControllerAdvice
public class CustomerRestExceptionHandler {
	// handler for CustomerNotFoundException exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handelException(CustomerNotFoundException exc) {
		// create exception object
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// handler for any exceptions
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handelException(Exception exc) {
		// create exception object
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
