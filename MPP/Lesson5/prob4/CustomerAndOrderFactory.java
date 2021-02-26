package prob4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final public class CustomerAndOrderFactory {
	private CustomerAndOrderFactory() {}
	//this function accepts customer name 
	// and orderNumber/name with corresponding list of items 
	public static CustomerAndOrder createCustomerOrder(String name, HashMap<String, List<String >> items){
		Customer cust = new Customer(name); 
		List<Order> orders = new ArrayList<>(); 
		Set<Entry<String, List<String>>> st = items.entrySet(); 
		for(Map.Entry<String, List<String>> item: st) {		
			Order order = Order.newOrder(cust, LocalDate.now());
			for(String newItem:item.getValue()) {
				order.addItem(newItem);
			}
			orders.add(order); 
		}

	 return new CustomerAndOrderImpl(cust, orders); 
	}
}
