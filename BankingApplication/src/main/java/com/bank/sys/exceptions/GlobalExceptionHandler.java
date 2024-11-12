package com.bank.sys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.sys.dto.ErrorDetail;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleAccountNotFoundException(AccountNotFoundException exception) {
        ErrorDetail errorDetail = new ErrorDetail(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ErrorDetail> handleInsufficientFundsException(InsufficientFundsException exception) {
        ErrorDetail errorDetail = new ErrorDetail(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleGeneralException(Exception exception) {
        ErrorDetail errorDetail = new ErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error: " + exception.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
