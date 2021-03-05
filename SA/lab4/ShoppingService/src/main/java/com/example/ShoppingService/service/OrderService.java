package com.example.ShoppingService.service;

import com.example.ShoppingService.model.Order;
import com.example.ShoppingService.model.ShoppingCart;
import com.example.ShoppingService.repository.OrderFactory;
import com.example.ShoppingService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order getOrder(String orderNumber) {
        Optional<Order> optOrder = orderRepository.findById(orderNumber);
        if (optOrder.isPresent()) {
            return optOrder.get();
        } else
            return null;
    }

    public void createOrder(ShoppingCart cart) {
        Order order = OrderFactory.createOrder(cart);
        orderRepository.save(order);
    }

}