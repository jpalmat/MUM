package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import shop.products.service.ProductDTO;
import shop.products.service.ProductRequest;
import shop.products.service.StockRequest;

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
	}
}