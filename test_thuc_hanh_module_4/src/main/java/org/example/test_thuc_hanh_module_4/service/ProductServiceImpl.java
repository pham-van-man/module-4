package org.example.test_thuc_hanh_module_4.service;

import org.example.test_thuc_hanh_module_4.model.Category;
import org.example.test_thuc_hanh_module_4.model.Product;
import org.example.test_thuc_hanh_module_4.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
}
