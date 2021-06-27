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
		
		
	}
}