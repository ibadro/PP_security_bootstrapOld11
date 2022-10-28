package pp.security_bootstrap1.controller;

import pp.security_bootstrap1.model.User;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import pp.security_bootstrap1.service.UserServiceImpl;


import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserServiceImpl userServiceImpl;

    public AdminController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping
    public String showAdminPage(Model model, Principal principal) {
        model.addAttribute("authorizedUser",
                userServiceImpl.getUserByName(principal.getName()));
        model.addAttribute("users", userServiceImpl.getAllUsers());
        model.addAttribute("newUser", new User());
        return "admin/admin";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("newUser") User user) {
        userServiceImpl.add(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) throws ChangeSetPersister.NotFoundException {
        userServiceImpl.update(user,id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) throws ChangeSetPersister.NotFoundException {
        userServiceImpl.delete(id);
        return "redirect:/admin";
    }

}