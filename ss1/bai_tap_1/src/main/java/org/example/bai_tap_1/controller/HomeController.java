package org.example.bai_tap_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "/Home";
    }
    @GetMapping("/result")
    public String result(@RequestParam double usd, Model model) {
        usd = usd * 23000;
        model.addAttribute("usd", usd);
        return "/Home";
    }
}
