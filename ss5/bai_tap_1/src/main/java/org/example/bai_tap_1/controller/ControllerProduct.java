package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.model.Product;
import org.example.bai_tap_1.service.ServiceProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControllerProduct {
    private final ServiceProduct serviceProduct;
    private Product product = new Product();

    public ControllerProduct(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    @ModelAttribute("product")
    public Product getProduct() {
        return product;
    }

    @ModelAttribute("products")
    public List<Product> getProducts() {
        return serviceProduct.getProducts(new Product());
    }

    @GetMapping("/")
    public String list(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("products", serviceProduct.getProducts(product));
        return "list";
    }

    @GetMapping("/view")
    public String view() {
        return "view";
    }

    @PostMapping("/save")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        serviceProduct.saveProduct(product);
        this.product = new Product();
        redirectAttributes.addFlashAttribute("messages", "Save successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id) {
        product = serviceProduct.getProduct(id);
        return "redirect:/view";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        serviceProduct.deleteProduct(id);
        return "redirect:/";
    }
}
