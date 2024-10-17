package org.example.test_thuc_hanh_module_4.service;

import org.example.test_thuc_hanh_module_4.model.Category;
import org.example.test_thuc_hanh_module_4.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    List<Product> getProductsByCategory(Category category);
}
