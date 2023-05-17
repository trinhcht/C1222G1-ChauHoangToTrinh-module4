package com.example.cart.service;

import com.example.cart.dto.CartDTO;
import com.example.cart.dto.ProductDTO;
import com.example.cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDTO> findAll();
    List<CartDTO> findAllCart();
    Optional<Product> findById(Long id);
}
