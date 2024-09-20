package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.model.Product;
import org.example.bai_tap_1.model.Search;
import org.example.bai_tap_1.service.ServiceProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControllerProduct {
    private ServiceProduct serviceProduct;
    private Product product = new Product();
    private Search keyword = new Search("");

    public ControllerProduct(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    @ModelAttribute("search")
    public Search search() {
        return keyword;
    }

    @ModelAttribute("product")
    public Product getProduct() {
        return product;
    }

    @ModelAttribute("productList")
    public List<Product> getProductList() {
        return serviceProduct.getProducts();
    }

    @GetMapping("/")
    public String list() {
        return "list";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        if (product.getId() == 0) {
            product.setId(serviceProduct.getProducts().size() + 1);
        }
        serviceProduct.updateProduct(product);
        this.product = new Product();
        redirectAttributes.addFlashAttribute("messages", "Save successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id) {
        System.out.println("Product ID: " + id);
        product = serviceProduct.getProduct(id);
        return "redirect:/add";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        serviceProduct.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("search") Search keyword, Model model) {
        if (keyword.getKeyword().isEmpty()) {
            List<Product> productList = serviceProduct.getProducts();
            model.addAttribute("productList", productList);
            this.keyword = new Search(keyword.getKeyword());
            return "list";
        } else {
            List<Product> productList = serviceProduct.findByName(keyword.getKeyword());
            model.addAttribute("productList", productList);
            this.keyword = keyword;
            return "list";
        }
    }
}
