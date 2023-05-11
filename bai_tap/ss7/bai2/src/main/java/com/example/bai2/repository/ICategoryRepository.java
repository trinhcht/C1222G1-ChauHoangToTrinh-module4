package com.example.bai2.repository;

import com.example.bai2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByNameCategory(String nameCategory);
    Category findById(int id);
}
