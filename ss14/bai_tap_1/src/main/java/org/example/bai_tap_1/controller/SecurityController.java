package org.example.bai_tap_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {
    @GetMapping("/login")
    public String loginPage(Model model, @RequestParam(value = "error", defaultValue = "") String error, @RequestParam(value = "logout", defaultValue = "") String logout) {
        if (!error.isEmpty()) {
            model.addAttribute("error", "Invalid username or password.");
        }
        if (!logout.isEmpty()) {
            model.addAttribute("logout", "You have been logged out.");
        }
        return "login";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage() {
        return "redirect:/login?logout=success";
    }
}

