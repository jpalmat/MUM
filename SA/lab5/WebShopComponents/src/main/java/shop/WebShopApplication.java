package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import shop.customers.service.AddressDTO;
import shop.customers.service.CustomerDTO;
import shop.order.service.OrderDTO;
import shop.order.service.OrderRequest;
import shop.products.service.ProductDTO;
import shop.products.service.ProductRequest;
import shop.products.service.StockRequest;
import shop.shopping.service.CartRequest;
import shop.shopping.service.ShoppingCartDTO;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

	HttpEntity<?> httpEntity = null;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		//create customer

		//todo: call the customer component to add the customer
		CustomerDTO customerDto = new CustomerDTO("1","Jimmy","Palma","jtigasi@miu.edu","123456789");
		AddressDTO addressDTO = new AddressDTO("1000 N main Street", "Fairfield","52557","USA");
		customerDto.setAddress(addressDTO);

		restTemplate.postForEntity("http://localhost:8080/customer", customerDto, CustomerDTO.class);

		// get customer
		//todo: call the customer component to get the customer with id 101 and print the result
		ResponseEntity<CustomerDTO> customer = restTemplate.exchange("http://localhost:8080/customer", HttpMethod.GET, httpEntity, CustomerDTO.class, customerDto);

		CustomerDTO customerDtoGet = customer.getBody();
		System.out.println(customerDtoGet);
		
		//create products
		
		//todo: call the product component to create the first product 
		//todo: call the product component to create the second product
		restTemplate.postForEntity("http://localhost:8080/product", new ProductRequest("111", "", 10.5), ProductRequest.class);
		restTemplate.postForEntity("http://localhost:8080/product", new ProductRequest("222", "", 10.5), ProductRequest.class);

		//set stock	
		//todo: call the product component to set the stock for the first product
		restTemplate.postForEntity("http://localhost:8080/product/stock/111", new StockRequest(1, "A1"), StockRequest.class);

		//get a product
		//todo: call the product component to get the the first product and print the result
		ProductRequest productRequest = new ProductRequest();
		productRequest.setProductnumber("111");
		ResponseEntity<ProductDTO> productEntity = restTemplate.postForEntity("http://localhost:8080/product", productRequest, ProductDTO.class);
		ProductDTO productDTO = productEntity.getBody();
		System.out.println("-----Product-------");
		productDTO.print();

		
		// add products to the shoppingcart
		//todo: call the shopping component to add the first product to the cart
		//todo: call the shopping component to add the second product to the cart
		restTemplate.postForEntity("http://localhost:8080/cart", new CartRequest("1", "111", 1), CartRequest.class);
		restTemplate.postForEntity("http://localhost:8080/cart", new CartRequest("2", "222", 1), CartRequest.class);

		////////NOOOO READY

		//get the shoppingcart
		//todo: call the shopping component to get the cart and print the result
		CartRequest cartRequest = new CartRequest();
		cartRequest.setCartId("1");
		httpEntity = new HttpEntity<CartRequest>(cartRequest, null);
		ResponseEntity<CartRequest> cartResponse = restTemplate.exchange("http://localhost:8080/cart", HttpMethod.GET, httpEntity, CartRequest.class, cartRequest);
		System.out.println("-----Shoppingcart-------");

		if (cartResponse.getBody() != null) System.out.println(cartResponse.getBody());

		//checkout the cart		
		//todo: call the shopping component to checkout the cart
		CartRequest cartRequestCheckout = new CartRequest();
		cartRequestCheckout.setCartId("1");
		restTemplate.postForEntity("\"http://localhost:8080/cart/checkout", cartRequest, CartRequest.class);
		
		//get the order
		//todo: call the order component to get the order and print the result
		OrderRequest orderRequest = new OrderRequest("1");
		httpEntity = new HttpEntity<OrderRequest>(orderRequest, null);

		ResponseEntity<OrderRequest> orderResponse = restTemplate.exchange("http://localhost:8080/order", HttpMethod.GET, httpEntity, OrderRequest.class, orderRequest);

		OrderDTO order = new OrderDTO();
		order.setOrdernumber(orderResponse.getBody().getOrderId());
		System.out.println("\n-----Order-------");
		if (order != null) order.print();
		
		//add customer to order
		//todo: call the order component to add a customer to the order
		restTemplate.postForLocation("http://localhost:8080/order/setCustomer/1/1", null);
		
		//confirm the order
		//todo: call the order component to confirm the order
		restTemplate.postForLocation("http://localhost:8080/order/1", null);
		
		//get the order
		//todo: call the order component to get the order and print the result
		OrderRequest orderConfirmedRequest = new OrderRequest("1");
		httpEntity = new HttpEntity<OrderRequest>(orderRequest, null);

		ResponseEntity<OrderRequest> orderConfirmedResponse = restTemplate.exchange("http://localhost:8080/order", HttpMethod.GET, httpEntity, OrderRequest.class, orderConfirmedRequest);

		OrderDTO orderConfirmed = new OrderDTO();
		orderConfirmed.setOrdernumber(orderConfirmedResponse.getBody().getOrderId());
		System.out.println("\n-----Order-------");
		if (order != null) orderConfirmed.print();
		
	}
}