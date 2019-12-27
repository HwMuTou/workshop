package com.example.security.workshop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/me")
public class MeController {

    @GetMapping
    public Authentication index(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
