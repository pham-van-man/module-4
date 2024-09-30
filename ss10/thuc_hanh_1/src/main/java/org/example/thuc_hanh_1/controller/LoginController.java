package org.example.thuc_hanh_1.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.thuc_hanh_1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser,
                        Model model) {
        if (!setUser.isEmpty()) {
            User loggedInUser = new User("abc", "xyz");
            model.addAttribute("user", loggedInUser);
            return "user";
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("cookieValue", setUser);
            return "login";
        }
    }

    @PostMapping("doLogin")
    public String doLogin(@ModelAttribute("user") User user,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (user.getEmail().equals("abc") && user.getPassword().equals("xyz")) {
            setUser = user.getEmail();
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            redirectAttributes.addFlashAttribute("message", "Login success. Welcome!");
        } else {
            user.setEmail("");
            redirectAttributes.addFlashAttribute("cookieValue", setUser);
            redirectAttributes.addFlashAttribute("message", "Login failed. Try again.");
        }
        return "redirect:";
    }

    @GetMapping("logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        request.getSession().invalidate();
        Cookie cookie = new Cookie("setUser", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:";
    }
}