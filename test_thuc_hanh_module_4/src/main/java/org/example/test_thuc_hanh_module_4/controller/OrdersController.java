package org.example.test_thuc_hanh_module_4.controller;

import jakarta.validation.Valid;
import org.example.test_thuc_hanh_module_4.DTO.OrdersDTO;
import org.example.test_thuc_hanh_module_4.model.Orders;
import org.example.test_thuc_hanh_module_4.service.OrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/order")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @ModelAttribute("ordersDTO")
    public OrdersDTO ordersDTO() {
        return new OrdersDTO();
    }

    @PostMapping("/edit")
    public String editOrder(@ModelAttribute OrdersDTO ordersDTO, RedirectAttributes redirectAttributes) {
        boolean error = false;
        Orders orders = new Orders();
        LocalDate localDate = LocalDate.now();
        if (ordersDTO.getOrderDate().isBefore(localDate)) {
            redirectAttributes.addFlashAttribute("errorOrderDate", "Ngày đặt hàng không thể ở quá khứ");
            error = true;
        }
        if (!(ordersDTO.getQuantity() > 0)) {
            redirectAttributes.addFlashAttribute("errorQuantity", "Số lượng phải lơn hơn không");
            error = true;
        }
        if (!error) {
            BeanUtils.copyProperties(ordersDTO, orders);
            ordersService.saveOrder(orders);
        }
        return "redirect:/home/order";
    }
}
