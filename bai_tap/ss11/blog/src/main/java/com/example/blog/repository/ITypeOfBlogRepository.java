package com.example.blog.repository;

import com.example.blog.model.TypeOfBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITypeOfBlogRepository extends JpaRepository<TypeOfBlog, Integer> {
}
