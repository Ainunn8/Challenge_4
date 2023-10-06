package com.example.Challenge_4.service;

import com.example.Challenge_4.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    //Menambahkan product baru
    Product addNewProduct(Product product);

    // Mengupdate detail product
    Product updateProduct(Product product);

    // Menghapus product berdasarkan productCode
    void deleteProduct(String productCode);

    // Menampilkan semua produk yang tersedia
    List<Product> getAllProducts();
}
