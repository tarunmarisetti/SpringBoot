package com.example.SpringbootsearchAPI.service;

import com.example.SpringbootsearchAPI.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> searchProducts(String query);

    void createProduct(Product product);

    List<Product> getAllProducts();
     Product getAProduct(Long id);

    void deleteProduct(Long id);
}
