package org.example.thuc_hanh_1.controller;

import org.example.thuc_hanh_1.model.Customer;
import org.example.thuc_hanh_1.service.ServiceCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControllerCustomer {
    private ServiceCustomer serviceCustomer;

    public ControllerCustomer(ServiceCustomer serviceCustomer) {
        this.serviceCustomer = serviceCustomer;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = serviceCustomer.findAll();
        model.addAttribute("customers", customerList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        serviceCustomer.save(customer);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("customer", serviceCustomer.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        serviceCustomer.save(customer);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", serviceCustomer.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        serviceCustomer.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", serviceCustomer.findById(id));
        return "view";
    }
}
