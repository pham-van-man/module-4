package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.model.Blog;
import org.example.bai_tap_1.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    private final BlogService blogService;
    private Blog blog = new Blog();

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @ModelAttribute("blogs")
    public List<Blog> getBlogs() {
        return blogService.getAllBlogs(blog);
    }

    @ModelAttribute("blog")
    public Blog blog() {
        return blog;
    }

    @GetMapping("/")
    public String list(@ModelAttribute("blog") Blog blog, Model model) {
        System.out.println(blogService.getAllBlogs(blog));
        model.addAttribute("blogs", blogService.getAllBlogs(blog));
        return "list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id) {
        Optional<Blog> blog = blogService.getBlogById(id);
        blog.ifPresent(value -> this.blog = value);
        return "redirect:/view";
    }

    @GetMapping("/view")
    public String view() {
        return "view";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.updateBlog(blog);
        this.blog = new Blog();
        redirectAttributes.addFlashAttribute("message", "Save successful");
        return "redirect:/";
    }

    @GetMapping("/add")
    public String add() {
        blog = new Blog();
        return "redirect:/view";
    }
}
