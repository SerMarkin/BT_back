package com.bartrip.main.entity.User;

import java.io.Serializable;

public class AuthenticationRequestDTO implements Serializable {
    private String email;
    private char[] password;
    
    public AuthenticationRequestDTO(String email, char[] password) {
        this.email = email;
        this.password = password;
    }
    public AuthenticationRequestDTO() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public char[] getPassword() {
        return password;
    }
    public void setPassword(char[] password) {
        this.password = password;
    }
}