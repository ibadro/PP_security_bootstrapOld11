package com.example.pp_security_bootstrap1.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/admin")
    public String redirectToAdminPage() {
        return "redirect:/admin";
    }

}