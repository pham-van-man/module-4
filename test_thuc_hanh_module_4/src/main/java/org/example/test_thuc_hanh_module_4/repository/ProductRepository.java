package org.example.test_thuc_hanh_module_4.repository;

import org.example.test_thuc_hanh_module_4.model.Category;
import org.example.test_thuc_hanh_module_4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
