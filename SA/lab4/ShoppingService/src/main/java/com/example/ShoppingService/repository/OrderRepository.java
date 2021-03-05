package com.example.ShoppingService.repository;

import com.example.ShoppingService.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}