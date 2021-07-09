
public class OrderReciever {
	
	private MostFavoriteCustomerOrderHandler mostFavoriteCustomerOrderHandler;
	
	public OrderReciever() {
		super();
		mostFavoriteCustomerOrderHandler= new MostFavoriteCustomerOrderHandler();
	}

	public void recieveOrder(Order order) {
		mostFavoriteCustomerOrderHandler.handleOrder(order);
	}

}
