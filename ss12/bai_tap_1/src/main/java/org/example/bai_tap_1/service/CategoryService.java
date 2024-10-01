package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    Category getCategoryById(Long id);

    void saveCategory(Category Category);

    void deleteCategory(Long id);
}
