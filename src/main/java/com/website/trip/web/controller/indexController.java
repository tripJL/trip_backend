package com.website.trip.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {

    @GetMapping("/api/index")
    public String index(){
        System.out.println("/api/index");
        return "안녕하세요";
    }
}
