package org.example.test_thuc_hanh_module_4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate orderDate;
    private int quantity;
    @ManyToOne
    private Product product;

    @PrePersist
    private void onCreate() {
        this.orderDate = LocalDate.now();
    }
}
