
public class LargeOrderHandler extends OrderHandler {

	public LargeOrderHandler() {
			super.successor = new InternationalOrderHandler();
	}

	@Override
	public void handleOrder(Order order) {
		// TODO Auto-generated method stub
		if (order.getTotalAmount()>LARGE_ORDER) {
			System.out.println("Large order");
		} else 
			successor.handleOrder(order);
	}

}
