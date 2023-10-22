package com.bartrip.main.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bartrip.main.entity.Bar.Bar;
import com.bartrip.main.repositories.BarRepository;
import com.google.inject.Inject;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/bar-admin")
@ResponseBody
@AllArgsConstructor(onConstructor_ = @Inject)
public class BarAdminRestController {
    
    private final BarRepository barRepository;

    @GetMapping(value = "/get-all")
    public List<Bar> helloString() {
        return barRepository.findAll();
    }


}
