package org.example.test_thuc_hanh_module_4.service;

import org.example.test_thuc_hanh_module_4.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface OrdersService {
    Page<Orders> getOrders(Pageable pageable);

    Page<Orders> getOrdersBetweenDates(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Orders> getTop5OrdersByTotalPrice(Pageable pageable);

    void saveOrder(Orders order);
}
