package integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	@Autowired
	private GreetingGateway gateway;
	
	@RequestMapping("/greeting/{name}")
	public List<Order> getGreeting(@PathVariable("name") String name) {
		Order order1 = new Order("order1",234.5);
		Order order2 = new Order("order2",75.6);
		Order order3 = new Order("order3",123.4);

		List<Order> orders = Arrays.asList(order1,order2,order3);

		Message<Order> orderMessage1 = org.springframework.integration.support.MessageBuilder.withPayload(order1).build();
		Message<Order> orderMessage2 = org.springframework.integration.support.MessageBuilder.withPayload(order2).build();
		Message<Order> orderMessage3 = MessageBuilder.withPayload(order3).build();


		List<Order> result=new ArrayList<>();
		result.add(gateway.handleRequest(orderMessage1));
		result.add(gateway.handleRequest(orderMessage2));
		result.add(gateway.handleRequest(orderMessage3));

		return result;
	}
}
