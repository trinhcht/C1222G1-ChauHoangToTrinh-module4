package com.example.bai2.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO {
    private Integer id;

    @NotEmpty(message = "Can not be blank or space")
    @Size(max = 800, min = 1, message = "Do not enter more than 800 characters")
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\\\\\-]).)*$", message = "No special characters")
    private String name;

    @NotNull(message = "Can not be blank or space")
    @Size(max = 300, min = 1, message = "Do not enter more than 300 characters")
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\\\\\-]).)*$", message = "No special characters")
    private String singer;

    @NotNull(message = "Can not be blank or space")
    @Size(max = 1000, min = 1, message = "Do not enter more than 1000 characters")
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\\\\\-]).)*$", message = "No special characters")
    private String category;

    public SongDTO() {
    }

    public SongDTO(Integer id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
