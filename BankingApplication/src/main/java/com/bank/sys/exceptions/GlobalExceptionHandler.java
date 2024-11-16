package com.bank.sys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.sys.dto.ApiResponse;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<ApiResponse<String>> handleMyExceptions(MyCustomException exception) {
        ApiResponse<String> errorDetail = new ApiResponse<>(exception.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(InsufficientFundsException.class)
//    public ResponseEntity<ApiResponse<String>> handleInsufficientFundsException(InsufficientFundsException exception) {
//        ApiResponse<String> errorDetail = new ApiResponse<String>(exception.getMessage());
//        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneralException(Exception exception) {
        ApiResponse<String> errorDetail = new ApiResponse<String>( "Internal Server Error: " + exception.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
