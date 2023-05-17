package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "type_of_blog")
public class TypeOfBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_of_blog")
    private Integer idTypeOfBlog;
    @Column(name = "name_type_of_blog")
    private String nameTypeOfBlog;

    public TypeOfBlog() {
    }

    public TypeOfBlog(Integer idTypeOfBlog, String nameTypeOfBlog) {
        this.idTypeOfBlog = idTypeOfBlog;
        this.nameTypeOfBlog = nameTypeOfBlog;
    }

    public Integer getIdTypeOfBlog() {
        return idTypeOfBlog;
    }

    public void setIdTypeOfBlog(Integer idTypeOfBlog) {
        this.idTypeOfBlog = idTypeOfBlog;
    }

    public String getNameTypeOfBlog() {
        return nameTypeOfBlog;
    }

    public void setNameTypeOfBlog(String nameTypeOfBlog) {
        this.nameTypeOfBlog = nameTypeOfBlog;
    }

}