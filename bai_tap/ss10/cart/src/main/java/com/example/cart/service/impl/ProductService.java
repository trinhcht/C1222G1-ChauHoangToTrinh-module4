package com.example.cart.service.impl;

import com.example.cart.dto.CartDTO;
import com.example.cart.dto.ProductDTO;
import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepository;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO;
        for (Product product : productList) {
            productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<CartDTO> findAllCart() {
        List<Product> productList = productRepository.findAll();
        List<CartDTO> productCartDTOList = new ArrayList<>();
        CartDTO cartDTO;
        for (Product product : productList) {
            cartDTO = new CartDTO();
            BeanUtils.copyProperties(product, cartDTO);
            productCartDTOList.add(cartDTO);
        }
        return productCartDTOList;
    }

    @Override
    public Product findById(int id) {
     return productRepository.findById(id).get();
    }
}