package com.example.Challenge_4.repository;

import com.example.Challenge_4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
