package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterCurrency {
    @GetMapping("/converter")
    public String success(@RequestParam(defaultValue = "0") int usd, Model model) {
        float result = usd*23000;
        model.addAttribute("result", result);
        return "/list";
    }
}
