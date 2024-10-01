package org.example.bai_tap_1.restful;

import org.example.bai_tap_1.model.Blog;
import org.example.bai_tap_1.service.BlogCategoryService;
import org.example.bai_tap_1.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class BlogRestfulController {
    private final BlogService blogService;

    public BlogRestfulController(BlogService blogService, BlogCategoryService blogCategoryService) {
        this.blogService = blogService;
    }

    @GetMapping
    private ResponseEntity<List<Blog>> getBlog() {
        return ResponseEntity.ok(blogService.getBlogs());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PostMapping
    private ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.saveBlog(blog));
    }

    @PutMapping
    private ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.saveBlog(blog));
    }

    @DeleteMapping({"/{id}"})
    private ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }
}
