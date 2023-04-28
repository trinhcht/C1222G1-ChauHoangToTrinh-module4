package com.example.demo.service.impl;

import com.example.demo.service.ICurrencyConversionService;

public class CurrencyConversionService implements ICurrencyConversionService {
    @Override
    public Double change(double usd) {
        double vnd= 23000 * usd;
        return vnd;
    }
}
