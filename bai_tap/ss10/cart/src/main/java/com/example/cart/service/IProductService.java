package com.example.cart.service;

import com.example.cart.dto.CartDTO;
import com.example.cart.dto.ProductDTO;
import com.example.cart.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();
    List<CartDTO> findAllCart();
    Product findById (int id);
}
