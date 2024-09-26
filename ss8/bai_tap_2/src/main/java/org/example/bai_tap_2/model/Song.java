package org.example.bai_tap_2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Bài hát không được để trống")
    @Size(min = 1, max = 800 ,message = "Bài hát có ít nhất 1 kí tự, tối đa 800 kí tự")
    @Pattern(regexp = "^[0-9À-ỹ]+$",message = "Bài hát không đúng định dạng")
    private String title;
    @NotBlank(message = "Tác giả không được để trống")
    @Size(min = 1, max = 300, message = "Tác giả có ít nhât 1 kí tự, tối đa 300 kí tự")
    @Pattern(regexp = "^[À-ỹ]+$", message = "Tác giả không đúng định dạng")
    private String artist;
    @NotBlank(message = "Thể loại không được để trông")
    @Size(min = 1, max = 1000, message = "Thể loại có ít nhất 1 kí tự, tối đa 1000 kí tự")
    @Pattern(regexp = "^[0-9À-ỹ,]+$", message = "Thể loại không đúng định dạng")
    private String genre;
}
