package org.example.bai_tap_1.repository;

import org.example.bai_tap_1.model.BlogCategory;
import org.example.bai_tap_1.model.CompositeKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, CompositeKey> {
    @Query("SELECT b FROM BlogCategory b WHERE b.blog.title LIKE :title AND b.category.name LIKE :category")
    Page<BlogCategory> findByTitleAndCategory(@Param("title") String title, @Param("category") String category, Pageable pageable);
}
