package integration;

import Order.Order;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface GreetingGateway {
	@Gateway(requestChannel = "inputChannel")
	Order handleRequest(Message<Order> message);
}