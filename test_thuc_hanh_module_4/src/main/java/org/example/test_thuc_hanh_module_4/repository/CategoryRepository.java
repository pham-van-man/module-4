package org.example.test_thuc_hanh_module_4.repository;

import org.example.test_thuc_hanh_module_4.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
