package com.example.bai1.model;

import javax.persistence.*;

@Entity
@Table(name = "blog_management")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String category;
    private String author;
    private String descrition;

    public Blog() {
    }

    public Blog(int id, String name, String category, String author, String descrition) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.descrition = descrition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }
}
