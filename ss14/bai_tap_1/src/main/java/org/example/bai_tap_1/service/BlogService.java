package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> getBlogs(String title,Pageable pageable);

    Blog getBlogById(Long id);

    Blog saveBlog(Blog Blog);

    void deleteBlog(Long id);
}
