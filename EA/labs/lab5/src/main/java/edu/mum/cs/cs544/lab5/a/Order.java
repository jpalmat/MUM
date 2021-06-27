package edu.mum.cs.cs544.lab5.a;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue
    private long orderId;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Set<OrderLine> orderLineList = new HashSet<OrderLine>();

    public Order() {
    }

    public Order(Date date) {
        this.date = date;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderLine> getOrderLineList() {
		return orderLineList;
	}

	public void setOrderLineList(Set<OrderLine> orderLineList) {
		this.orderLineList = orderLineList;
	}
	
	public void addOrderLineList(OrderLine orderLine) {
		this.orderLineList.add(orderLine);
	}
}