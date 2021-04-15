package Order;

public class Order {
    private String orderNumber; private double amount;

    public double getAmount() {
        return this.amount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Order(String orderNumber, double amount) {
        this.orderNumber=orderNumber;
        this.amount=amount;
    }

    public String toString(){
        return "order: nr="+orderNumber+" amount="+amount;
    }
}
