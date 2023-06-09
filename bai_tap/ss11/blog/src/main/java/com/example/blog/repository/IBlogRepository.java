package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blogs join type_of_blog on type_of_blog.id_type_of_blog = blogs.id_type_of_blog where name_blog like concat('%', :name,'%')", nativeQuery = true)
    List<Blog> findByName(String name);

    @Query(value = "select * from blogs where id_type_of_blog = :id_type_of_blog", nativeQuery = true)
    List<Blog> findByType(@Param("id_type_of_blog") Integer id);
}