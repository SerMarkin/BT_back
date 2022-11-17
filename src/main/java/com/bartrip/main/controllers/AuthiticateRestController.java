package com.bartrip.main.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bartrip.main.entity.User.AuthenticationRequestDTO;
import com.bartrip.main.services.AuthiticateRestService;

@Controller
@RequestMapping("/auth")
public class AuthiticateRestController {
    
    private final AuthiticateRestService authiticateRestService;
    

    public AuthiticateRestController(AuthiticateRestService authiticateRestService) {
        this.authiticateRestService = authiticateRestService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO request) {
        Map<Object,Object> response = new HashMap<>();
        try{
            String token = this.authiticateRestService.createTokenByEmail(request);
            response.put("token", token);
            return ResponseEntity.ok(response);
        }catch (AuthenticationException e){
            e.printStackTrace();
            response.put("message", "Invalide email or password");
            return new ResponseEntity<>(response,HttpStatus.valueOf(401));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerByEmail(@RequestBody AuthenticationRequestDTO request) {
        Map<Object,Object> response = new HashMap<>();
        String token = this.authiticateRestService.registrationByEmail(request);
        response.put("token", token);
        return ResponseEntity.ok(response);

    }


    @PostMapping("/logout")
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(httpServletRequest, httpServletResponse, null);
    }


}
