package org.example.bai_tap_2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    private final Service SERVICE;

    public HomeController(Service SERVICE) {
        this.SERVICE = SERVICE;
    }

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/result")
    public String result(@RequestParam String keyword, Model model) {
        String string = SERVICE.getString(keyword);
        model.addAttribute("keyword", string);
        return "/home";
    }
}
