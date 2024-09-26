package org.example.bai_tap_1.controller;

import jakarta.validation.Valid;
import org.example.bai_tap_1.model.User;
import org.example.bai_tap_1.service.UserService;
import org.example.bai_tap_1.validate.UserValidate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {
    private final UserService userService;
    private final UserValidate userValidate;

    public FormController(UserService userService, UserValidate userValidate) {
        this.userService = userService;
        this.userValidate = userValidate;
    }

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping("")
    public String form() {
        return "formRegister";
    }

    @PostMapping("")
    public String register(@ModelAttribute @Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        userValidate.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "formRegister";
        }
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("user", user);
        redirectAttributes.addFlashAttribute("isRegister", true);
        return "redirect:";
    }
}
