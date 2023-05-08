package ss5.ss5.repository;

import ss5.ss5.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listProductByName(String name);
    void createProduct (Product product);
    Product findById (int id);
    void updateProduct(int id, Product product);
    void deleteProduct (int id);

    List<Product> findAll();
}
