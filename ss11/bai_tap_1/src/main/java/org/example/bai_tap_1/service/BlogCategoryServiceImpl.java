package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Blog;
import org.example.bai_tap_1.model.BlogCategory;
import org.example.bai_tap_1.model.Category;
import org.example.bai_tap_1.model.CompositeKey;
import org.example.bai_tap_1.repository.BlogCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCategoryServiceImpl implements BlogCategoryService {
    private final BlogCategoryRepository blogCategoryRepository;

    public BlogCategoryServiceImpl(BlogCategoryRepository blogCategoryRepository) {
        this.blogCategoryRepository = blogCategoryRepository;
    }

    @Override
    public Page<BlogCategory> getBlogs(BlogCategory blogCategory, Pageable pageable) {
        if (blogCategory.getBlog() == null) {
            blogCategory.setBlog(new Blog());
            blogCategory.getBlog().setTitle("");
        } else if (blogCategory.getBlog().getTitle() == null) {
            blogCategory.getBlog().setTitle("");
        }
        if (blogCategory.getCategory() == null) {
            blogCategory.setCategory(new Category());
            blogCategory.getCategory().setName("");
        } else if (blogCategory.getCategory().getName() == null) {
            blogCategory.getCategory().setName("");
        }
        String title = "%" + blogCategory.getBlog().getTitle() + "%";
        String category = "%" + blogCategory.getCategory().getName() + "%";
        return blogCategoryRepository.findByTitleAndCategory(title, category, pageable);
    }

    @Override
    public BlogCategory getBlogCategory(CompositeKey compositeKey) {
        return blogCategoryRepository.findById(compositeKey).orElse(null);
    }

    @Override
    public void deleteBlogCategory(CompositeKey compositeKey) {
        blogCategoryRepository.deleteById(compositeKey);
    }

    @Override
    public BlogCategory saveBlogCategory(BlogCategory blogCategory) {
        return blogCategoryRepository.save(blogCategory);
    }

    @Override
    public List<Blog> findByCategory(Long id) {
        return blogCategoryRepository.findByCategory(id);
    }
}
