package org.example.test_thuc_hanh_module_4.controller;

import org.example.test_thuc_hanh_module_4.DTO.OrdersDTO;
import org.example.test_thuc_hanh_module_4.model.Category;
import org.example.test_thuc_hanh_module_4.model.Orders;
import org.example.test_thuc_hanh_module_4.service.CategoryService;
import org.example.test_thuc_hanh_module_4.service.OrdersService;
import org.example.test_thuc_hanh_module_4.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final OrdersService ordersService;
    private final CategoryService categoryService;

    public HomeController(OrdersService ordersService,
                          CategoryService categoryService) {
        this.ordersService = ordersService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("ordersDTO")
    public OrdersDTO ordersDTO() {
        return new OrdersDTO();
    }

    @GetMapping("/order")
    public String order(Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<Orders> orders = ordersService.getOrders(pageable);
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("orders", orders);
        return "index";
    }

    @GetMapping("/orderBetweenDates")
    public String orderBetweenDates(Model model,
                                    @RequestParam(value = "startDate", defaultValue = "") LocalDate startDate,
                                    @RequestParam(value = "endDate", defaultValue = "") LocalDate endDate,
                                    @PageableDefault(size = 2) Pageable pageable) {
        if (startDate.isAfter(endDate)) {
            model.addAttribute("error", "Ngày bắt đầu phải trước hoặc bằng ngày kết thúc");
        }
        Page<Orders> orders = ordersService.getOrdersBetweenDates(startDate, endDate, pageable);
        model.addAttribute("orders", orders);
        return "index";
    }

    @GetMapping("/topOrder")
    public String topOrder(Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<Orders> orders = ordersService.getTop5OrdersByTotalPrice(pageable);
        model.addAttribute("orders", orders);
        return "index";
    }
}
