package com.example.SpringbootsearchAPI.service;

import com.example.SpringbootsearchAPI.entity.Product;
import com.example.SpringbootsearchAPI.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> searchProducts(String query) {
        return productRepository.searchProducts(query);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    @Override
    public Product getAProduct(Long id) {
        Optional<Product> productResponse =  productRepository.findById(id);
        return productResponse.get();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteAllById(Collections.singleton(id));
    }
}
