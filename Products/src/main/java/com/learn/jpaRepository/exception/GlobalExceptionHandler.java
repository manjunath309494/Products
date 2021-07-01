package com.learn.jpaRepository.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ProductException.class)
    public ResponseEntity blogNotFoundException(ProductException booKException) {
        return new ResponseEntity(booKException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
