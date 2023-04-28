package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import com.codegym.service.impl.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class Dictionary {
    private IDictionaryService iDictionaryService = new DictionaryService();

    @GetMapping("")
    public String dictionary(@RequestParam(required = false) String english, Model model) {
        if (english == null) {
            return "list";
        }
        model.addAttribute("english", english);
        model.addAttribute("result", iDictionaryService.list(english));
        return "list";
    }
}
