package com.example.Challenge_4.controller;

import com.example.Challenge_4.model.Merchant;
import com.example.Challenge_4.model.Product;
import com.example.Challenge_4.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/Product")
@Slf4j

public class ProductController {

    @Autowired
    ProductService productService;

    // Menambahkan produk baru
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody Product  product) {
        productService.addNewProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
    }

    // Mengupdate detail produk
    @PutMapping("/update")
    public ResponseEntity updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //Menghapus produk
    @DeleteMapping("/delete/{product}")
    public ResponseEntity deleteProduct(@PathVariable String productCode) {
        productService.deleteProduct(productCode);
        return ResponseEntity.ok("Product deleted successfully");
    }

    // Menampilkan produk yang tersedia
    @GetMapping("/Open")
    public List<Product> getAllProducts() {
        List<Product> openMerchants = productService.getAllProducts();
        return getAllProducts();
    }

}
