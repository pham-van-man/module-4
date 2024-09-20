package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceProductImpl implements ServiceProduct {
    private static Map<Integer, Product> map = new HashMap<>();

    static {
        map.put(1, new Product(1, "1", 1));
        map.put(2, new Product(2, "2", 2));
        map.put(3, new Product(3, "3", 3));
        map.put(4, new Product(4, "4", 4));
        map.put(5, new Product(5, "5", 5));
        map.put(6, new Product(6, "6", 6));
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Product getProduct(int id) {
        return map.get(id);
    }

    @Override
    public void updateProduct(Product product) {
        map.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(int id) {
        map.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : map.values()) {
            if (product.getName().equals(name)) {
                products.add(product);
            }
        }
        return products;
    }
}
