package org.example.bai_tap_1.restful;

import org.example.bai_tap_1.model.Blog;
import org.example.bai_tap_1.model.Category;
import org.example.bai_tap_1.service.BlogCategoryService;
import org.example.bai_tap_1.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryRestfulController {
    private final CategoryService categoryService;
    private final BlogCategoryService blogCategoryService;

    public CategoryRestfulController(CategoryService categoryService, BlogCategoryService blogCategoryService) {
        this.categoryService = categoryService;
        this.blogCategoryService = blogCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Blog>> getBlogsByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(blogCategoryService.findByCategory(id));
    }
}
