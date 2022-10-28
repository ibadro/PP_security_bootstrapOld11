package pp.security_bootstrap1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pp.security_bootstrap1.model.User;
import pp.security_bootstrap1.service.UserServiceImpl;


import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;
@Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public String getUser(Principal principal, Model model) {
        model.addAttribute("authorizedUser",
                userServiceImpl.getUserByName(principal.getName()));
        model.addAttribute("users", userServiceImpl.getAllUsers());
        model.addAttribute("newUser", new User());
        return "user/user";
    }
}
