package com.example.pp_security_bootstrap1.controller;

import com.example.pp_security_bootstrap1.model.User;
import com.example.pp_security_bootstrap1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAdminPage(Model model, Principal principal) {
        model.addAttribute("authorizedUser",
                userService.findByUsername(principal.getName()));
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) throws ChangeSetPersister.NotFoundException {
        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) throws ChangeSetPersister.NotFoundException {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}