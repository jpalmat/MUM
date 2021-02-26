package com.example.ShoppingService.controller;

import com.example.ShoppingService.model.Product;
import com.example.ShoppingService.model.Stock;
import com.example.ShoppingService.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jimmypalma
 */
@RestController
public class ProductController {
    @Autowired
    ProductCatalogService productCatalogService;

    @GetMapping("/product/{productnumber}")
    public ResponseEntity<?> getContact(@PathVariable String productnumber) {
        Product product = productCatalogService.getProduct(productnumber);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productCatalogService.addProduct(product.getProductnumber(), product.getDescription(), product.getPrice());
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @PostMapping(value = "/product/stock/{productnumber}")
    public ResponseEntity<?> setStock(@PathVariable String productnumber, @RequestBody Stock stock){
        productCatalogService.setStock(productnumber, stock.getQuantity(), stock.getLocationcode());
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
}