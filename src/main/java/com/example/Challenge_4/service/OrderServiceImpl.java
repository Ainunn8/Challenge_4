package com.example.Challenge_4.service;

import com.example.Challenge_4.model.Order;
import com.example.Challenge_4.model.Product;
import com.example.Challenge_4.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //    @Override
//    public Order createOrder(Order order) {
//        return orderRepository.save(order);
//    }

    @Override
    public Order makeOrder(String userId, List<Product> products, String shippingAddress, String destination) {
        return null;
    }

    @Override
    public List<Order> getAllOrders(String userId) {
        return orderRepository.findAll();
    }
}
