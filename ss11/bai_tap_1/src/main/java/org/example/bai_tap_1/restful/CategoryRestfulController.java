package org.example.bai_tap_1.restful;

import org.example.bai_tap_1.model.Blog;
import org.example.bai_tap_1.model.Category;
import org.example.bai_tap_1.service.BlogCategoryService;
import org.example.bai_tap_1.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> getBlogsByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(blogCategoryService.findByCategory(id));
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }
}
