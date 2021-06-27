package edu.mum.cs.cs544.lab5.b;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine1 {
    @Id
    @GeneratedValue
    private long id;
    private int quantity;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product1 product;

    public OrderLine1() {
    }

    public OrderLine1(int quantity, Product1 product) {
        this.quantity = quantity;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	public Product1 getProduct() {
		return product;
	}

	public void setProduct(Product1 product) {
		this.product = product;
	}
}