package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.model.MailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailConfigController {
    private MailConfig mailConfig = new MailConfig();

    @ModelAttribute("mailConfig")
    public MailConfig getMailConfig() {
        return mailConfig;
    }

    @GetMapping("/")
    public String getMailConfig(Model model) {
        return "home";
    }

    @PostMapping("/saveConfig")
    public String saveMailConfig(@ModelAttribute MailConfig mailConfig) {
        this.mailConfig = mailConfig;
        return "redirect:/";
    }
}

