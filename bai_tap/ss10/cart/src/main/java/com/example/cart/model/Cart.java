package com.example.cart.model;

import com.example.cart.dto.ProductDTO;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> productMap = new LinkedHashMap<>();

    public Cart() {
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            productMap.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            productMap.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void removeProduct(Product product) {
        if (checkItemInCart(product)) {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            int value = itemEntry.getValue();
            if (value == 1){
                productMap.remove(product);
            }
                Integer newQuantity = itemEntry.getValue() - 1;
                productMap.replace(itemEntry.getKey(), newQuantity);

            }
        }


    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return productMap.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}
