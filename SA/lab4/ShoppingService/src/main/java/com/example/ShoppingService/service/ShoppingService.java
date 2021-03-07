package com.example.ShoppingService.service;

import com.example.ShoppingService.model.Product;
import com.example.ShoppingService.model.ShoppingCart;
import com.example.ShoppingService.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingService {
    @Autowired
    ProductCatalogService productCatalogService;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    OrderService orderService;

    public void addToCart(String cartId, String productnumber, int quantity) {
        Product product = productCatalogService.getProduct(productnumber);
        Optional<ShoppingCart> previousCart = shoppingCartRepository.findById(cartId);
        if (previousCart.isPresent() && product != null) {
            ShoppingCart cart = previousCart.get();
            cart.addToCart(product, quantity);
            shoppingCartRepository.save(cart);
        }
        else if (product != null) {
            ShoppingCart cart = new ShoppingCart();
            cart.setCartid(cartId);
            cart.addToCart(product, quantity);
            shoppingCartRepository.save(cart);
        }
    }

    public ShoppingCart getCart(String cartId) {
        Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
        if (cart.isPresent())
            return cart.get();
        else
            return null;
    }

    public void checkout(String cartId) {
        Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
        if (cart.isPresent()) {
            orderService.createOrder(cart.get());
        }
    }
}