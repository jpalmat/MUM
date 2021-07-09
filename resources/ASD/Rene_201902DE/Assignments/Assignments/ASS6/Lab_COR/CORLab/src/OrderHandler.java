
public abstract class OrderHandler {
	final public static double LARGE_ORDER=30000;
	protected OrderHandler successor;
	
	public abstract void handleOrder(Order order);
}	
