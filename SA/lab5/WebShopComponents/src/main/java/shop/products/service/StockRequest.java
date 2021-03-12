package shop.products.service;

public class StockRequest {
    int quantity;
    String locationcode;

    public StockRequest(int quantity, String locationcode) {
        super();
        this.quantity = quantity;
        this.locationcode = locationcode;
    }

    public StockRequest() {
        super();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocationcode() {
        return locationcode;
    }

    public void setLocationcode(String locationcode) {
        this.locationcode = locationcode;
    }
}