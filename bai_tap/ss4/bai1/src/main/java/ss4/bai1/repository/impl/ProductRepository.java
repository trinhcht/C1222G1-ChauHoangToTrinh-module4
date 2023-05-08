package ss4.bai1.repository.impl;

import org.springframework.stereotype.Repository;
import ss4.bai1.model.Product;
import ss4.bai1.repository.IProductRepository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Bánh quy", 25000,"Bánh", "Cosy"));
        productList.add(new Product(2, "Kẹo dẻo", 20000, "Kẹo", "Habaco"));
        productList.add(new Product(3, "Đường", 15000,"Gia vị", "Sugar"));
    }

    @Override
    public List<Product> listProductByName(String name) {
        if (name == null) {
            return productList;
        }
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public void createProduct(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        Product products = new Product();
        for (Product product : productList) {
            if (id == product.getId()) {
               products = product;
            }
        }
        return products;
    }

//    @Override
//    public Product findById(int id) {
//        for (Product product : productList) {
//            if (id == product.getId()) {
//                return product;
//            }
//        }
//        return null;
//    }

    @Override
    public void updateProduct(int id, Product product) {
        for (Product value : productList) {
            if (product.getId() == value.getId()) {
                value.setName(product.getName());
                value.setPrice(product.getPrice());
                value.setDescribe(product.getDescribe());
                value.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        productList.remove(findById(id));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}