package Order;

public class OrderFilter {
    public boolean filter(Order order) {
        if (order.getAmount() >= 175) return true;
        else
            return false;
    }
}
