package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Dictionary {
    @GetMapping("/dictionary")
    public String dictionary(@RequestParam(required = false) String english , Model model) {
        if (english == null) {
            model.addAttribute("english", english);
            return "search";
        }
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        model.addAttribute("english", english);
        String mess = "Not found";
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals(english)) {
                int index = list.indexOf(english);
                List<String> listViet = new ArrayList<>();
                listViet.add("một");
                listViet.add("hai");
                listViet.add("ba");
                String result = listViet.get(index);
                model.addAttribute("result", result);
                break;
            }
            model.addAttribute("result",mess);
        }
        return "search";
    }
}
