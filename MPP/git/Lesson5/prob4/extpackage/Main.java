package prob4.extpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import prob4.Customer;
import prob4.CustomerAndOrder;
import prob4.CustomerAndOrderFactory;
import prob4.CustomerAndOrderImpl;
import prob4.Order;

public class Main {
	public static void main(String[] args) {
		
		HashMap<String, List<String>> orderItem = new HashMap<>(); 
		List<String> firstOrder = new ArrayList<>(); 
		
		firstOrder.add("Shirt"); 
		firstOrder.add("Laptop");
		
		List<String> secondOrder = new ArrayList<>(); 
		secondOrder.add("Pants");
		secondOrder.add("Knife set");
		
		orderItem.put("1", firstOrder); 
		orderItem.put("2", secondOrder); 
		
		CustomerAndOrder customerOrdrr = CustomerAndOrderFactory.createCustomerOrder("bob", orderItem); 
		
		
		//orderItem.put("Bob", "Shirt"); 
		
//		Customer cust = new Customer("Bob");
//		Order order = Order.newOrder(cust, LocalDate.now());
//		order.addItem("Shirt");
//		order.addItem("Laptop");
//
//		order = Order.newOrder(cust, LocalDate.now());
//		order.addItem("Pants");
//		order.addItem("Knife set");

		System.out.println(customerOrdrr.getOrder());
	}
}

		
