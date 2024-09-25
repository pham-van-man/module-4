package org.example.bai_tap_1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompositeKey implements Serializable {
    private Long blogId;
    private Long categoryId;
}
