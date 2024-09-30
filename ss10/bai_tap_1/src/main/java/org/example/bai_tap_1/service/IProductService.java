package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Product;

public interface IProductService {
    Iterable<Product> findAll();

    Product findById(Long id);
}
