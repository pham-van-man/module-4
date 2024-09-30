package org.example.thuc_hanh_2.service;

import org.example.thuc_hanh_2.model.Product;

public interface IProductService {
    Iterable<Product> findAll();

    Product findById(Long id);
}
