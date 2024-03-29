package com.bartrip.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.inject.Inject;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/")
@ResponseBody
@AllArgsConstructor(onConstructor_ = @Inject)
public class BaseController {

    @GetMapping(value = "/")
    public String helloString() {
        return "ok";
    }

    @GetMapping(value = "/secure")
    public String secureString() {
        return "Token passed \n";
    }

    @GetMapping(value = "/secure_admin")
    public String secureAdminString() {
        return "Token admin success \n";
    }

}
