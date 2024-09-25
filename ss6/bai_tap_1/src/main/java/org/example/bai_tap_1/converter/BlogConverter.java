package org.example.bai_tap_1.converter;

import org.example.bai_tap_1.model.Blog;
import org.springframework.core.convert.converter.Converter;

public class BlogConverter implements Converter<String, Blog> {
    private final String pattern;

    public BlogConverter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Blog convert(String title) {
        Blog blog = new Blog();
        blog.setTitle(title.replace(" ", pattern));
        return blog;
    }
}
