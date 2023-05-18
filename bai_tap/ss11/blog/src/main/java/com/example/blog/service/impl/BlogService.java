package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;


//    @Override
//    public List<Blog> findAll() {
//        return repository.findAll();
//    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public List<Blog> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Blog> findByType(Integer id) {
        return repository.findByType(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

}