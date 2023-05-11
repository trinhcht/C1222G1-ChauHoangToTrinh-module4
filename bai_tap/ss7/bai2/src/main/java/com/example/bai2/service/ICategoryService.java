package com.example.bai2.service;


import com.example.bai2.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    void delete(int id);

    void update(Category category);

    Category findById(int id);
}
