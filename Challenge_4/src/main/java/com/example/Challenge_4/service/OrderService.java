package com.example.Challenge_4.service;

import com.example.Challenge_4.model.Order;

import java.util.List;

public interface OrderService {

   // Membuat pesanan baru
    Order createOrder(Order order);

    // Menampilkan semua pesanan
    List<Order> getAllOrders();
}
