package org.example.bai_tap_1.restful;

import org.example.bai_tap_1.model.Blog;
import org.example.bai_tap_1.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class BlogRestfulController {
    private final BlogService blogService;

    public BlogRestfulController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    private ResponseEntity<List<Blog>> getBlog() {
        return ResponseEntity.ok(blogService.getBlogs());
    }

    @GetMapping("{id}")
    private ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

}
