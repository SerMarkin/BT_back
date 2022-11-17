package com.bartrip.main.entity.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginError<T> extends ResponseEntity<T> {

    public LoginError(T body, HttpStatus status) {
        super(body, HttpStatus.BAD_REQUEST);
    }
    
}
