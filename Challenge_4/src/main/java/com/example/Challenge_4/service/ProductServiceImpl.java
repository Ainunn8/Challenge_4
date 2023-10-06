package com.example.Challenge_4.service;

import com.example.Challenge_4.model.Product;
import com.example.Challenge_4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String productCode) {
        productRepository.deleteById(productCode);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
