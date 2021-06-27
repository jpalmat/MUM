package edu.mum.cs.cs544.exercises.e;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer1 {
	@Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private List<Reservation1> reservationList = new ArrayList<Reservation1>();

    public Customer1() {
    }

    public Customer1(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation1> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation1> reservationList) {
        this.reservationList = reservationList;
    }

    public void addReservation(Reservation1 reservation){
        reservationList.add(reservation);
    }
}
