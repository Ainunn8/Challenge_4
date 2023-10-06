package com.example.Challenge_4.repository;

import com.example.Challenge_4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.ParseException;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> getMenu();
}
