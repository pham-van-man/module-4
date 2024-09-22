package org.example.bai_tap_1.repository;

import org.example.bai_tap_1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findBlogByTitleLikeOrContentLike(String title, String content);
}
