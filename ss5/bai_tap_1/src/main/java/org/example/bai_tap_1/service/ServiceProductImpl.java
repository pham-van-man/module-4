package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Product;
import org.example.bai_tap_1.repository.RepositoryProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductImpl implements ServiceProduct {
    private final RepositoryProduct repositoryProduct;

    public ServiceProductImpl(RepositoryProduct repositoryProduct) {
        this.repositoryProduct = repositoryProduct;
    }

    @Override
    public List<Product> getProducts(Product product) {
        return repositoryProduct.getProducts(product);
    }

    @Override
    public Product getProduct(int id) {
        return repositoryProduct.getProduct(id);
    }

    @Override
    public void saveProduct(Product product) {
        repositoryProduct.saveProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        repositoryProduct.deleteProduct(id);
    }
}
