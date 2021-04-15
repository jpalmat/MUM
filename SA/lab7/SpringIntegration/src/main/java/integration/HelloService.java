package integration;

import Order.Order;

public class HelloService {
	public String sayHello(String name) throws Exception {
		System.out.println("Hello " + name);
		return "Hello " + name;
	}

	public void handle(Order order) throws Exception {
		System.out.println("OrderService receiving order: " + order.toString());
	}
}
