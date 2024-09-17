package com.example.workintech.service;

import com.example.workintech.entity.Product;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getTopLikedProducts();
    void deleteProduct(Long id);
}
