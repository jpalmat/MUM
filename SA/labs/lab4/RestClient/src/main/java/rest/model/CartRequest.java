package rest.model;

public class CartRequest {
    String cartId;
    String productnumber;
    int quantity;

    public CartRequest() {
    }

    public CartRequest(String cartId, String productnumber, int quantity) {
        this.cartId = cartId;
        this.productnumber = productnumber;
        this.quantity = quantity;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(String productnumber) {
        this.productnumber = productnumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}