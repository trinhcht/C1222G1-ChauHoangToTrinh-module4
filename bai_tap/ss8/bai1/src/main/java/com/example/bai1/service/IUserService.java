package com.example.bai1.service;

import com.example.bai1.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void create(User user);
}
