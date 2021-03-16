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

import shop.order.service.OrderDTO;
import shop.order.service.OrderRequest;

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