package com.wu.springbootdemo.MySpringBootRestApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   // using tnis annotation it makes centralized exception handler
public class CustomerRESTExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException cnef) {
		CustomerErrorResponse myResponse = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), cnef.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity(myResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e) {
		CustomerErrorResponse myResponse = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity(myResponse,HttpStatus.BAD_REQUEST);
	}
}
