package com.example.blog.service.impl;

import com.example.blog.model.TypeOfBlog;
import com.example.blog.repository.ITypeOfBlogRepository;
import com.example.blog.service.ITypeOfBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TypeOfBlogService implements ITypeOfBlogService {
    @Autowired
    ITypeOfBlogRepository typeOfBlogRepository;

    @Override
    public List<TypeOfBlog> findAll() {
        return (List<TypeOfBlog>) typeOfBlogRepository.findAll();
    }
}