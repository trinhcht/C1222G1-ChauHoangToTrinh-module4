package com.example.demo.controller;

import com.example.demo.service.ICurrencyConversionService;
import com.example.demo.service.impl.CurrencyConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterCurrency {
    private ICurrencyConversionService iCurrencyConversionService = new CurrencyConversionService();

    @GetMapping("/converter")
    public String currencyConversion(@RequestParam(required = false) Double usd, @RequestParam(required = false) Double vnd, Model model) {
        if (usd == null) {
            model.addAttribute("usd", usd);
            return "list";
        }
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", iCurrencyConversionService.change(usd));
        return "list";
    }
}
