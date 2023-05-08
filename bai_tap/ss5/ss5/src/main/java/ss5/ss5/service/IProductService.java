package ss5.ss5.service;

import ss5.ss5.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> listProductByName(String name);
    List<Product> findAll();
    void createProduct (Product product);
    Product findById (int id);
    void updateProduct(int id, Product product);
    void deleteProduct (int id);
}
