
public class Order {
	private long orderNumber;
	private double totalAmount;
	private boolean international;
	private Customer customer;
	
	public Order(long orderNumber, double totalAmount, boolean international, Customer customer) {
		super();
		this.orderNumber = orderNumber;
		this.totalAmount = totalAmount;
		this.international = international;
		this.customer = customer;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public boolean isInternational() {
		return international;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	
	
}
