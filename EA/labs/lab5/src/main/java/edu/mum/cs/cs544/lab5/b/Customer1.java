package edu.mum.cs.cs544.lab5.b;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer1 {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
    private Set<Order1> orderList = new HashSet<Order1>();

    public Customer1() {
    }

    public Customer1(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

	public Set<Order1> getOrderList() {
		return orderList;
	}

	public void setOrderList(Set<Order1> orderList) {
		this.orderList = orderList;
	}

	public void addOrder(Order1 order) {
		order.setCustomer(this);
		this.orderList.add(order);
	}
}