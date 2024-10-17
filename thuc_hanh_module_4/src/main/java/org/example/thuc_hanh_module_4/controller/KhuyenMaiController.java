package org.example.thuc_hanh_module_4.controller;

import jakarta.validation.Valid;
import org.example.thuc_hanh_module_4.model.KhuyenMai;
import org.example.thuc_hanh_module_4.service.KhuyenMaiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class KhuyenMaiController {
    private final KhuyenMaiService khuyenMaiService;

    public KhuyenMaiController(KhuyenMaiService khuyenMaiService) {
        this.khuyenMaiService = khuyenMaiService;
    }

    @ModelAttribute("khuyenMai")
    public KhuyenMai getKhuyenMai() {
        return new KhuyenMai();
    }

    @GetMapping("/")
    public String index(Model model) {
        List<KhuyenMai> khuyenMais = khuyenMaiService.getAllKhuyenMai();
        model.addAttribute("khuyenMais", khuyenMais);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        khuyenMaiService.deleteKhuyenMai(id);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String edit(@PathVariable Long id, Model model) {
        KhuyenMai khuyenMai = khuyenMaiService.getKhuyenMai(id);
        model.addAttribute("khuyenMai", khuyenMai);
        return "detail";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute @Valid KhuyenMai khuyenMai, BindingResult bindingResult) {
        if (khuyenMai.getEndTime().isBefore(khuyenMai.getStartTime())) {
            bindingResult.rejectValue("endTime", "endTime", "Ngay ket thuc phai cach ngay bat dau it nhat mot ngay");
        }
        if (khuyenMai.getEndTime().isEqual(khuyenMai.getStartTime())) {
            bindingResult.rejectValue("endTime", "endTime", "Ngay ket thuc phai cach ngay bat dau it nhat mot ngay");
        }
        if (bindingResult.hasErrors()) {
            return "detail";
        }
        khuyenMaiService.saveKhuyenMai(khuyenMai);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("khuyenMai", new KhuyenMai());
        return "detail";
    }

    @PostMapping("/q")
    public String search(@RequestParam(value = "startTime", defaultValue = "") LocalDate startDate,
                         @RequestParam(value = "endTime", defaultValue = "") LocalDate endDate,
                         @RequestParam(value = "q", defaultValue = "0") double q, Model model) {
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(q);
        List<KhuyenMai> khuyenMais = khuyenMaiService.searchKhuyenMai(startDate, endDate, q);
        System.out.println(khuyenMais);
        model.addAttribute("khuyenMais", khuyenMais);
        return "index";
    }
}
