package org.example.thi_thuc_hanh_module_4.controller;

import jakarta.validation.Valid;

import org.example.thi_thuc_hanh_module_4.model.Brand;
import org.example.thi_thuc_hanh_module_4.model.Pig;
import org.example.thi_thuc_hanh_module_4.service.BrandService;
import org.example.thi_thuc_hanh_module_4.service.PigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {
    private final PigService pigService;
    private final BrandService brandService;

    public HomeController(PigService pigService, BrandService brandService) {
        this.pigService = pigService;
        this.brandService = brandService;
    }

    @ModelAttribute("brands")
    public List<Brand> brands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam(value = "q", defaultValue = "") String q, @RequestParam(value = "status", defaultValue = "") String status, @RequestParam(value = "brand", defaultValue = "") String brandName) {
        Page<Pig> pigList = pigService.getPigs(pageable, q, status, brandName);
        model.addAttribute("pigList", pigList);
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Pig pig = pigService.getPig(id);
        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
        model.addAttribute("pig", pig);
        return "detail";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("pig") @Valid Pig pig, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "detail";
        }
        Pig oldPig = pigService.getPig(pig.getId());
        oldPig.setCode(pig.getCode());
        oldPig.setTimeIn(pig.getTimeIn());
        oldPig.setWeightIn(pig.getWeightIn());
        oldPig.setTimeOut(pig.getTimeOut());
        oldPig.setWeightOut(pig.getWeightOut());
        oldPig.setBrand(pig.getBrand());
        pigService.SavePig(pig);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Pig pig = pigService.getPig(id);
        pigService.deletePig(pig);
        return "redirect:/list";
    }

    @GetMapping("/sell/{id}")
    public String sell(@PathVariable Long id) {
        Pig pig = pigService.getPig(id);
        pig.setTimeOut(LocalDate.now());
        pigService.SavePig(pig);
        return "redirect:/list";
    }

    @GetMapping("/top")
    public String top(@PageableDefault(size = 2) Pageable pageable, Model model) {
        Page<Pig> pigs = pigService.getPigsByWeightOut(pageable);
        model.addAttribute("pigList", pigs);
        return "index";
    }
}
