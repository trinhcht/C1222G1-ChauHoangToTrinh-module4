package com.example.bai1.controller;

import com.example.bai1.model.Blog;
import com.example.bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("")
    public String showList(Model model){
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList",blogList);
        return "/list";
    }
}
