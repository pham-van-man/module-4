package org.example.thuc_hanh_module_4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Khong duoc de trong")
    private String title;
    @Future(message = "Thoi gian khuyen mai phai o tuong lai")
    private LocalDate startTime;
    private LocalDate endTime;
    @Range(min = 10000, message = "Muc khuyen mai phai lon hon 10000")
    private double rate;
    @NotBlank(message = "Khong duoc de trong")
    private String descriptions;
}
