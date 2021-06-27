package prob4;

import java.util.List;

final public class CustomerAndOrderImpl implements CustomerAndOrder {
	private Customer customer; 
	private List<Order> order; 
	
	CustomerAndOrderImpl(Customer customer, List<Order> order) {
		this.customer = customer;
		this.order = order;
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public List<Order> getOrder() {
		return order; 
	}

}
