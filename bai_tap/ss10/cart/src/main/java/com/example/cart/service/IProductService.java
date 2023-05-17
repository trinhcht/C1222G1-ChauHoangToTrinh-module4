package com.example.cart.service;

import com.example.cart.dto.CartDTO;
import com.example.cart.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();
    List<CartDTO> findAllCart();
    ProductDTO findById (int id);
}
