package com.example.Challenge_4.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.Challenge_4.model.Order;
import com.example.Challenge_4.model.request.OrderRequest;
import com.example.Challenge_4.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/Order")
@Slf4j

public class OrderController {

    @Autowired
    private OrderService orderService;

    // Membuat pesanan
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(
            @RequestBody OrderRequest orderRequest
    ) {
        // Anda perlu membuat OrderRequest yang berisi userId, produk, alamat pengiriman, dan tujuan
        Order newOrder = orderService.makeOrder(
                orderRequest.getUserId(),
                orderRequest.getProducts(),
                orderRequest.getShippingAddress(),
                orderRequest.getDestination()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }
//    @PostMapping("/create")
//    public ResponseEntity createOrder(@RequestBody Order order) {
//        Order newOrder = orderService.createOrder(order);
//        return ResponseEntity.ok("Add new order successful!");
//    }

    // Menampilkan pesanan
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam String userId) {
        List<Order> orders = orderService.getAllOrders(userId);
        if (!orders.isEmpty()) {
            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
    }
}
