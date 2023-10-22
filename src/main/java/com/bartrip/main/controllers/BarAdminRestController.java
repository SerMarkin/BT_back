package com.bartrip.main.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bartrip.main.entity.Bar.Bar;
import com.bartrip.main.services.barAdmin.BarAdminService;
import com.google.inject.Inject;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/bar-admin")
@ResponseBody
@AllArgsConstructor(onConstructor_ = @Inject)
public class BarAdminRestController {
    
    private final BarAdminService barAdminService;

    @GetMapping(value = "/get-all")
    public List<Bar> helloString() {
        return barAdminService.getAllBar();
    }

    @PostMapping(value = "create-bar")
    public void createBar(@RequestBody() Bar bar) {
        barAdminService.createBar(bar);
    }

    public void updateBar(@RequestBody() Bar bar) {
        barAdminService.updateBar(bar);
    }

}
