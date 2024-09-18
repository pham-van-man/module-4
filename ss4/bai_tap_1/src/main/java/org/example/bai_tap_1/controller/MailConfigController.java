package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.model.MailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailConfigController {
    private MailConfig mailConfig = new MailConfig();

    @GetMapping("/")
    public String getMailConfig(Model model) {
        model.addAttribute("mailConfig", mailConfig);
        return "home";
    }

    @PostMapping("/saveConfig")
    public String saveMailConfig(@ModelAttribute MailConfig mailConfig, RedirectAttributes redirectAttributes) {
        this.mailConfig = mailConfig;
        redirectAttributes.addFlashAttribute("mailConfig", this.mailConfig);
        return "redirect:/";
    }
}

