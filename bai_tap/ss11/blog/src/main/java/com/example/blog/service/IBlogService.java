package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

//    List<Blog> findAll();

    void save(Blog blog);

    Optional<Blog> findById(int id);

    void delete(Integer id);

    List<Blog> findByName(String name);

    List<Blog> findByType(Integer id);
    Page<Blog> findAll(Pageable pageable);
}
