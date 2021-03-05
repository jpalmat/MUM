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
}
