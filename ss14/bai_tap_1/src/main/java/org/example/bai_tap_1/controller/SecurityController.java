package org.example.bai_tap_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {
    @GetMapping("/login")
    public String loginPage(Model model, @RequestParam(value = "error", defaultValue = "") String error) {
        if (!error.isEmpty()) {
            model.addAttribute("error", "Invalid username or password.");
        }
        return "login";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "redirect:/login";
    }
}

