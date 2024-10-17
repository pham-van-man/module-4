package org.example.test_thuc_hanh_module_4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.test_thuc_hanh_module_4.model.Product;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {
    private Long id;
    private Product product;
    private LocalDate orderDate;
    private int quantity;
}
