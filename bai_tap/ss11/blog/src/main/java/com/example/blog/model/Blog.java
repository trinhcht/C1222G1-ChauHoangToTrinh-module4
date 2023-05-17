package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private Integer idBlog;
    @Column(name = "name_blog", columnDefinition = "varchar(100)", nullable = false)
    private String nameBlog;
    @Column(name = "content_blog", columnDefinition = "varchar(1000)", nullable = false)
    private String contentBlog;
    @Column(name = "author_blog")
    private String authorBlog;
    @Column(name = "date_create_blog", columnDefinition = "DATE")
    private String dateCreateBlog;
    @ManyToOne
    @JoinColumn(name = "id_type_of_blog")
    private TypeOfBlog typeOfBlog;

    public Blog() {
    }

    public Blog(Integer idBlog, String nameBlog, String contentBlog, String authorBlog, String dateCreateBlog, TypeOfBlog typeOfBlog) {
        this.idBlog = idBlog;
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
        this.authorBlog = authorBlog;
        this.dateCreateBlog = dateCreateBlog;
        this.typeOfBlog = typeOfBlog;
    }

    public Blog(String nameBlog, String contentBlog, String authorBlog, String dateCreateBlog, TypeOfBlog typeOfBlog) {
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
        this.authorBlog = authorBlog;
        this.dateCreateBlog = dateCreateBlog;
        this.typeOfBlog = typeOfBlog;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public String getAuthorBlog() {
        return authorBlog;
    }

    public void setAuthorBlog(String authorBlog) {
        this.authorBlog = authorBlog;
    }

    public String getDateCreateBlog() {
        return dateCreateBlog;
    }

    public void setDateCreateBlog(String dateCreateBlog) {
        this.dateCreateBlog = dateCreateBlog;
    }

    public TypeOfBlog getTypeOfBlog() {
        return typeOfBlog;
    }

    public void setTypeOfBlog(TypeOfBlog typeOfBlog) {
        this.typeOfBlog = typeOfBlog;
    }
}