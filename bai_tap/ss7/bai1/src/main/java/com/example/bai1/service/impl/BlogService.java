package com.example.bai1.service.impl;

import com.example.bai1.model.Blog;
import com.example.bai1.repository.IBlogRepository;
import com.example.bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
@Autowired
private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }
}
