package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Blog;
import org.example.bai_tap_1.repository.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Page<Blog> getBlogs(String title, Pageable pageable) {
        if (title == null || title.isEmpty()) {
            title = "";
        }
        String content = "%" + title + "%";
        return blogRepository.findByTitle(content, pageable);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog saveBlog(Blog Blog) {
        return blogRepository.save(Blog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
