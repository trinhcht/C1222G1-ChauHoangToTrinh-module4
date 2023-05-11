package com.example.bai2.service.impl;

import com.example.bai2.blogDto.BlogDto;
import com.example.bai2.model.Blog;
import com.example.bai2.repository.IBlogRepository;
import com.example.bai2.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByTitle(String title, Pageable pageable) {
        return iBlogRepository.findByTitle(title, pageable);
    }

    @Override
    public List<BlogDto> showListDto() {
        return iBlogRepository.showListDto();
    }

}
