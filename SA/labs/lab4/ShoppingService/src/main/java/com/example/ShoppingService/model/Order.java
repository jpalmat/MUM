package com.example.ShoppingService.model;

import java.util.Date;

public class Order {
    String orderId;
    String cartid;
    Date date = new Date();
    public Order(String orderId, String cartid) {
        this.orderId = orderId;
        this.cartid = cartid;
    }
}
