package org.example.test_thuc_hanh_module_4.repository;

import org.example.test_thuc_hanh_module_4.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o WHERE o.orderDate >= :startOrder AND o.orderDate <= :endOrder")
    Page<Orders> findOrdersBetweenDates(@Param("startOrder") LocalDate startOrder, @Param("endOrder") LocalDate endOrder, Pageable pageable);

    @Query("SELECT o FROM Orders o ORDER BY (o.product.price * o.quantity) DESC")
    Page<Orders> findTop5OrdersByTotalPrice(Pageable pageable);
}
