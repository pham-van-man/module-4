package org.example.thuc_hanh_2.service;

import org.example.thuc_hanh_2.model.Product;
import org.example.thuc_hanh_2.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
