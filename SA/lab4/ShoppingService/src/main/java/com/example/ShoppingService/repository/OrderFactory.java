package com.example.ShoppingService.repository;

import com.example.ShoppingService.model.CartLine;
import com.example.ShoppingService.model.Order;
import com.example.ShoppingService.model.ShoppingCart;

import java.util.Date;

public class OrderFactory {
    public static Order createOrder(ShoppingCart cart) {
        Order order = new Order(cart.getCartid(), new Date(),"placed");
        return order;
    }
}