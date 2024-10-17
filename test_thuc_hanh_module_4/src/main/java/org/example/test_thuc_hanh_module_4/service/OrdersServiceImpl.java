package org.example.test_thuc_hanh_module_4.service;

import org.example.test_thuc_hanh_module_4.model.Orders;
import org.example.test_thuc_hanh_module_4.repository.OrdersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Page<Orders> getOrders(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    @Override
    public Page<Orders> getOrdersBetweenDates(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return ordersRepository.findOrdersBetweenDates(startDate, endDate, pageable);
    }

    @Override
    public Page<Orders> getTop5OrdersByTotalPrice(Pageable pageable) {
        return ordersRepository.findTop5OrdersByTotalPrice(pageable);
    }

    @Override
    public void saveOrder(Orders order) {
        ordersRepository.save(order);
    }
}
