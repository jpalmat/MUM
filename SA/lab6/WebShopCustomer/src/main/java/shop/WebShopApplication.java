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
	}
}