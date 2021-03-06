package rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rest.model.Product;

@RestController
public class ClientController {

    StringBuilder baseUrl = new StringBuilder("http://localhost:8080/");

    @GetMapping(value = "/productClient")
    public ResponseEntity<Product> addProduct(){
        RestTemplate restTemplate = new RestTemplate();

        baseUrl.append("product");
        Product product = new Product("126", "rest client", 11.0);

        restTemplate.postForEntity(baseUrl.toString(), product, Product.class);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

}