package com.utkarsh.dsatracker.controller;

import com.utkarsh.dsatracker.model.User;
import com.utkarsh.dsatracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "index"; 
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {

        if (userService.userExists(username)) {
            model.addAttribute("error", "Username already exists! Try a different one.");
            return "signup"; 
        }


        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userService.registerUser(newUser);


        return "redirect:/login?registered";
    }
}
