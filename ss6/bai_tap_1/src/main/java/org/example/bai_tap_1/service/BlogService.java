package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog createBlog(Blog blog);

    List<Blog> getAllBlogs(Blog blog);

    Optional<Blog> getBlogById(Long id);

    void updateBlog(Blog updatedBlog);

    void deleteBlog(Long id);
}
