package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Product;

import java.util.List;

public interface ServiceProduct {
    List<Product> getProducts();

    Product getProduct(int id);

    void updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> findByName(String name);
}
