package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.model.Cart;
import org.example.bai_tap_1.model.Product;
import org.example.bai_tap_1.service.IProductService;
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
    public String addToCart(@PathVariable Long id, @SessionAttribute Cart cart, @RequestParam(value = "action", defaultValue = "") String action) {
        Product product = productService.findById(id);
        if (action.equals("increment")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        } else if (action.equals("-")) {
            cart.reduceQuantity(product);
            return "redirect:/shopping-cart";
        } else {
            cart.addProduct(product);
            return "redirect:/shop";
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("productDetail");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/remove-product/{id}")
    public String removeProduct(@PathVariable Long id, @SessionAttribute Cart cart) {
        Product product = productService.findById(id);
        cart.removeProduct(product);
        return "redirect:/shopping-cart";
    }
}
