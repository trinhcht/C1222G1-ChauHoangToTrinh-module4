package com.codegym.service.impl;

import com.codegym.service.ICurrencyConversionService;

public class CurrencyConversionService implements ICurrencyConversionService {
    @Override
    public Double change(double usd) {
        double vnd= 23000 * usd;
        return vnd;
    }
}
