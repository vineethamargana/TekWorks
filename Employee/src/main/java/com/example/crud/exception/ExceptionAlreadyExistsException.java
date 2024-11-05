package com.example.crud.exception;

public class ExceptionAlreadyExistsException extends RuntimeException {
    public ExceptionAlreadyExistsException(String message) {
        super(message); // Passes the error message to the superclass (RuntimeException)
    }

}
