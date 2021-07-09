
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer1 = new Customer("Younes");
		Customer customer2 = new Customer("Hesham");
		Customer customer3 = new Customer("Rene");
		
		MostFavoriteCustomer.addCustomer("Rene");
		
		Order order1 = new Order(1, 2000, false, customer2);
		Order order2 = new Order(2, 40000, false, customer1);
		Order order3 = new Order(3, 5000, true, customer1);
		Order order4 = new Order(4, 2000, false, customer3);
		Order order5 = new Order(5, 45000, false, customer3);
		
		OrderReciever orderReciever = new OrderReciever();
		orderReciever.recieveOrder(order1);
		orderReciever.recieveOrder(order2);
		orderReciever.recieveOrder(order3);
		orderReciever.recieveOrder(order4);
		orderReciever.recieveOrder(order5);
	}

}
