package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Product;

import java.util.List;

public interface ServiceProduct {
    List<Product> getProducts(Product product);

    Product getProduct(int id);

    void saveProduct(Product product);

    void deleteProduct(int id);
}
