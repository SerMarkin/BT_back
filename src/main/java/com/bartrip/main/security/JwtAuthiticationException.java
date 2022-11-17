package com.bartrip.main.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

public class JwtAuthiticationException extends AuthenticationException {

    private HttpStatus httpStatus;


    public JwtAuthiticationException(String msg) {
        super(msg);
    }

    public JwtAuthiticationException(String msg, Throwable cause) {
        super(msg, cause);
        //TODO Auto-generated constructor stub
    }

    public JwtAuthiticationException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    

}
