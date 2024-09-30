package org.example.thuc_hanh_2.controller;

import org.example.thuc_hanh_2.model.Cart;
import org.example.thuc_hanh_2.model.Product;
import org.example.thuc_hanh_2.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam(value = "action", defaultValue = "") String action) {
        Product product = productService.findById(id);
        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        } else {
            cart.addProduct(product);
            return "redirect:/shop";
        }
    }
}
