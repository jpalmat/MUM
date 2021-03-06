package com.example.ShoppingService.controller;

import com.example.ShoppingService.model.ShoppingCart;
import com.example.ShoppingService.model.request.CartRequest;
import com.example.ShoppingService.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingService shoppingService;

    @PostMapping(value = "/cart")
    public ResponseEntity<?> addToCart(@RequestBody CartRequest cartRequest) {
        shoppingService.addToCart(cartRequest.getCartId(), cartRequest.getProductnumber(), cartRequest.getQuantity());
        return new ResponseEntity<ShoppingCart>(HttpStatus.OK);
    }

    @GetMapping("/cart/{cartId}")
    public ResponseEntity<?> getCart(@RequestBody CartRequest cartRequest) {
        ShoppingCart cart = shoppingService.getCart(cartRequest.getCartId());
        return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
    }

    @PostMapping(value = "/cart/checkout/{cartId}")
    public ResponseEntity<?> checkoutCart(@RequestBody CartRequest cartRequest) {
        shoppingService.checkout(cartRequest.getCartId());
        return new ResponseEntity<ShoppingCart>(HttpStatus.OK);
    }
}