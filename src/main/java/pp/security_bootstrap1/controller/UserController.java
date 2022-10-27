package pp.security_bootstrap1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pp.security_bootstrap1.model.User;
import pp.security_bootstrap1.service.UserService;
import pp.security_bootstrap1.service.UserServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final UserService userService;
    public UserController(UserServiceImpl userServiceImpl, UserService userService) {
        this.userServiceImpl = userServiceImpl;
        this.userService = userService;
    }

    @GetMapping()
    public String getUser(Principal principal, Model model) {
        model.addAttribute("logUser", userServiceImpl.findByUsername(principal.getName()));
        model.addAttribute("authorizedUser",
                userService.findByUsername(principal.getName()));
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("newUser", new User());
        return "user/user";
    }
}
