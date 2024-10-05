package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.model.*;
import org.example.bai_tap_1.service.BlogCategoryService;
import org.example.bai_tap_1.service.BlogService;
import org.example.bai_tap_1.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/home")
public class BlogCategoryController {
    private final BlogCategoryService blogCategoryService;
    private final CategoryService categoryService;
    private final BlogService blogService;
    private BlogCategory blogCategory = new BlogCategory();

    public BlogCategoryController(BlogCategoryService blogCategoryService, CategoryService categoryService, BlogService blogService) {
        this.blogCategoryService = blogCategoryService;
        this.categoryService = categoryService;
        this.blogService = blogService;
    }

    @ModelAttribute("blogDTO")
    public BlogDTO getBlogDTO() {
        return new BlogDTO();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @ModelAttribute("blog")
    public BlogCategory blog() {
        return blogCategory;
    }

    @GetMapping
    public String list(@ModelAttribute("blog") BlogCategory blogCategory, Model model, @PageableDefault(size = 1, sort = "blog.title", direction = Sort.Direction.ASC) Pageable pageable) {
        String sort = pageable.getSort().toString().replace(": ", ",");
        model.addAttribute("sort", sort);
        model.addAttribute("blogs", blogCategoryService.getBlogs(blogCategory, pageable));
        return "list";
    }

    @GetMapping("/delete/CompositeKey")
    public String delete(@RequestParam() Long blogId, Long categoryId, RedirectAttributes redirectAttributes) {
        CompositeKey compositeKey = new CompositeKey(blogId, categoryId);
        blogCategoryService.deleteBlogCategory(compositeKey);
        redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
        return "redirect:/home";
    }

    @GetMapping("/CompositeKey")
    public String edit(@RequestParam() Long blogId, Long categoryId) {
        CompositeKey compositeKey = new CompositeKey(blogId, categoryId);
        this.blogCategory = blogCategoryService.getBlogCategory(compositeKey);
        return "redirect:/home/view";
    }

    @GetMapping("/view")
    public String view() {
        return "view";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") BlogCategory blogCategory, RedirectAttributes redirectAttributes) {
        blogService.saveBlog(blogCategory.getBlog());
        blogCategoryService.saveBlogCategory(blogCategory);
        this.blogCategory = new BlogCategory();
        redirectAttributes.addFlashAttribute("message", "Save successful");
        return "redirect:/home";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blogDTO") BlogDTO blogDTO, RedirectAttributes redirectAttributes) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog = blogService.saveBlog(blog);
        CompositeKey compositeKey = new CompositeKey(blog.getId(), blogDTO.getCategory().getId());
        BlogCategory blogCategory = new BlogCategory(compositeKey, blog, blogDTO.getCategory());
        blogCategoryService.saveBlogCategory(blogCategory);
        redirectAttributes.addFlashAttribute("message", "Save successful");
        return "redirect:/home";
    }
}
