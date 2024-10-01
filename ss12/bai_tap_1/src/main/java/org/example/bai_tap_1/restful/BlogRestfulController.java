package org.example.bai_tap_1.restful;

import org.example.bai_tap_1.model.Blog;
import org.example.bai_tap_1.service.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/blog")
public class BlogRestfulController {
    private final BlogService blogService;

    public BlogRestfulController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    private ResponseEntity<Page<Blog>> getBlog(@RequestParam(value = "search", defaultValue = "") String title, @PageableDefault(size = 2) Pageable pageable) {
        System.out.println("Title:" + title);
        return ResponseEntity.ok(blogService.getBlogs(title, pageable));
    }

    @GetMapping("{id}")
    private ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

}
