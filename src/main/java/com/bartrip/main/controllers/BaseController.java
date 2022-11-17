package com.bartrip.main.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@ResponseBody
public class BaseController {
    
    @GetMapping(value="/")
    public String helloString() {
        return "Hello world!";
    }

    @GetMapping(value = "/secure")
    public String secureString() {
        return "Token passed";
    }
    

}
