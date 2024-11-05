package com.example.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	 @ResponseStatus(HttpStatus.NOT_FOUND)
	 @ExceptionHandler(EmployeeNotFoundException.class)
	 public String handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
	        return ex.getMessage(); // Returns the exception message directly
	 }
	 
	 @ResponseStatus(HttpStatus.CONFLICT) // Sets the response status to 409 (Conflict)
	    @ExceptionHandler(ExceptionAlreadyExistsException.class) // Handles EmployeeAlreadyExistsException
	    public String handleEmployeeAlreadyExistsException(ExceptionAlreadyExistsException ex) {
	        return ex.getMessage(); // Returns the exception message as the response body
	    }
}

