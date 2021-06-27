package com.example.ShoppingService.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;


/**
 * @author jimmypalma
 */
public class ShoppingCart {
    @Id
    String cartid;

    ArrayList<CartLine> cartlineList = new ArrayList<CartLine>();

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public ArrayList<CartLine> getCartlineList() {
        return cartlineList;
    }

    public void setCartlineList(ArrayList<CartLine> cartlineList) {
        this.cartlineList = cartlineList;
    }

    public void addToCart(Product product, int quantity) {
        for (CartLine cline : cartlineList) {
            if (cline.getProduct().getProductnumber().equals(product.getProductnumber())) {
                cline.setQuantity(cline.getQuantity()+quantity);
                return;
            }
        }
        CartLine cline = new CartLine();
        cline.setProduct(product);
        cline.setQuantity(quantity);
        cartlineList.add(cline);
    }
}
