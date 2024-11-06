package com.example.product.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ExceptionHandler(ProductNotFoundException.class)
	    public String handleProductNotFoundException(ProductNotFoundException ex) {
	        return ex.getMessage(); // Returns the exception message directly
	    }

}
