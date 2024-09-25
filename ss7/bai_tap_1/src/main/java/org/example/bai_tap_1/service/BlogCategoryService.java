package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.BlogCategory;
import org.example.bai_tap_1.model.CompositeKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogCategoryService {
    Page<BlogCategory> getBlogs(BlogCategory blogCategory, Pageable pageable);

    BlogCategory getBlogCategory(CompositeKey compositeKey);

    void deleteBlogCategory(CompositeKey compositeKey);

    void saveBlogCategory(BlogCategory blogCategory);
}
