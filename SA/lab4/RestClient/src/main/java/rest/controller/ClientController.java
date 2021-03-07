package rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rest.model.CartRequest;
import rest.model.OrderRequest;
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

    @GetMapping(value = "/cartClient")
    public ResponseEntity<CartRequest> addProductToShoppingcart(){
        RestTemplate restTemplate = new RestTemplate();

        baseUrl.append("cart");
        CartRequest cartRequest = new CartRequest("1", "123", 3);

        restTemplate.postForEntity(baseUrl.toString(), cartRequest, CartRequest.class);
        return new ResponseEntity<CartRequest>(cartRequest, HttpStatus.OK);
    }

    @GetMapping(value = "/orderClient")
    public ResponseEntity<CartRequest> checkoutShoppingcartToCreateAnOrder(){
        RestTemplate restTemplate = new RestTemplate();

        baseUrl.append("cart/checkout");
        CartRequest cartRequest = new CartRequest();
        cartRequest.setCartId("1");

        restTemplate.postForEntity(baseUrl.toString(), cartRequest, CartRequest.class);
        return new ResponseEntity<CartRequest>(cartRequest, HttpStatus.OK);
    }

    @GetMapping(value = "/orderRequestClient")
    public ResponseEntity<OrderRequest> retrieveOrder(){
        RestTemplate restTemplate = new RestTemplate();

        baseUrl.append("order");
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId("1");

        ResponseEntity<OrderRequest> order = restTemplate.postForEntity(baseUrl.toString(), orderRequest, OrderRequest.class);
        return new ResponseEntity<OrderRequest>(orderRequest, HttpStatus.OK);
    }

}