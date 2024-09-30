package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getBlogs();

    Blog getBlogById(Long id);

    Blog saveBlog(Blog Blog);

    void deleteBlog(Long id);
}
