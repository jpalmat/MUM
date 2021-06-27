package com.example.ShoppingService.repository;

import com.example.ShoppingService.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jimmypalma
 */
public interface ProductRepository extends MongoRepository<Product, String> {

}