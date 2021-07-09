
public class MostFavoriteCustomerOrderHandler extends OrderHandler {

	public MostFavoriteCustomerOrderHandler() {
			super.successor = new LargeOrderHandler();
	}

	@Override
	public void handleOrder(Order order) {
		// TODO Auto-generated method stub
		if (MostFavoriteCustomer.checkCustomerIsFavorite(order.getCustomer().getName())) {
			System.out.println("Favorite customer order");
		} else 
			successor.handleOrder(order);
	}

}
