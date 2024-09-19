package org.example.bai_tap_3.controller;

import org.example.bai_tap_3.model.HealthDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerHealthDeclaration {
    private HealthDeclaration healthDeclaration = new HealthDeclaration();

    @ModelAttribute("healthDeclaration")
    public HealthDeclaration getHealthDeclaration() {
        return healthDeclaration;
    }

    @GetMapping("/")
    public String showForm() {
        return "healthDeclarationForm";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("healthDeclaration") HealthDeclaration healthDeclaration) {
        this.healthDeclaration = healthDeclaration;
        return "redirect:/";
    }
}
