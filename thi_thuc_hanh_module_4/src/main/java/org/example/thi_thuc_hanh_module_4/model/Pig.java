package org.example.thi_thuc_hanh_module_4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String code;
    @PastOrPresent(message = "Ngày nhập phải ở quá khứ")
    private LocalDate timeIn;
    @FutureOrPresent(message = "Ngày xuất phải ở tương lai")
    private LocalDate timeOut;
    private double weightIn;
    private double weightOut;
    @ManyToOne
    private Brand brand;
}
