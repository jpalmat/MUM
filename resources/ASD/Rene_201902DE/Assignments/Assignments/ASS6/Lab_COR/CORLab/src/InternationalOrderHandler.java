
public class InternationalOrderHandler extends OrderHandler {

	public InternationalOrderHandler() {
			super.successor = new DomesticOrderHandler();
	}

	@Override
	public void handleOrder(Order order) {
		// TODO Auto-generated method stub
		if (order.isInternational()) {
			System.out.println("International order");
		} else 
			successor.handleOrder(order);
	}

}
