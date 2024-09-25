package org.example.bai_tap_1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogCategory {
    @EmbeddedId
    private CompositeKey id;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("blogId")
    private Blog blog;
    @ManyToOne
    @MapsId("categoryId")
    private Category category;
}
