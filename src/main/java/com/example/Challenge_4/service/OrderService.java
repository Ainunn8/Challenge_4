package com.example.Challenge_4.service;

import com.example.Challenge_4.model.Order;
import com.example.Challenge_4.model.Product;

import java.util.List;

public interface OrderService {

   // Membuat pesanan baru
   Order makeOrder(String userId, List<Product> products, String shippingAddress, String destination);
//    Order createOrder(Order order);

    // Menampilkan semua pesanan
    List<Order> getAllOrders(String userId);
}
