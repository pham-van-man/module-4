package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Blog;
import org.example.bai_tap_1.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAllBlogs(Blog blog) {
        if (blog.getContent() == null) {
            blog.setContent("");
        }
        String content = "%" + blog.getContent() + "%";
        return blogRepository.findBlogByTitleLikeOrContentLike(content, content);
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public void updateBlog(Blog updatedBlog) {
        blogRepository.save(updatedBlog);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
