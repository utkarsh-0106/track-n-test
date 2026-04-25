package com.utkarsh.dsatracker.controller;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        if (principal != null && principal instanceof org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken token) {
            OAuth2User user = token.getPrincipal();
            String name = user.getAttribute("name");
            model.addAttribute("name", name);
        } else {
            model.addAttribute("name", "Guest");
        }
        return "index"; 
    }
}
