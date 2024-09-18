package org.example.bai_tap_2.controller;

import org.example.bai_tap_2.model.Calculator;
import org.example.bai_tap_2.service.ServiceCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    private ServiceCalculator serviceCalculator;

    public HomeController(ServiceCalculator serviceCalculator) {
        this.serviceCalculator = serviceCalculator;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/result")
    public String result(@ModelAttribute Calculator calculator, Model model) {
        double result = serviceCalculator.result(calculator);
        model.addAttribute("result", result);
        return "home";
    }
}
