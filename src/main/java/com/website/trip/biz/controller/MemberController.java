package com.website.trip.biz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/member/index")
    public String member() {
        return "";
    }
}
