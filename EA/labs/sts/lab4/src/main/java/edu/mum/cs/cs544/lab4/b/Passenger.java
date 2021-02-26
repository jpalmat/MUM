package edu.mum.cs.cs544.lab4.b;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Passenger {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="passenger_id")
	private Set<Flight> flightList = new HashSet<Flight>();
	
	public Passenger() {
		super();
	}
	public Passenger(String name) {
		super();
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
	public Set<Flight> getFlightList() {
		return flightList;
	}
	public void setFlightList(Set<Flight> flightList) {
		this.flightList = flightList;
	}
	
	public void addFlight(Flight flight) {
		this.flightList.add(flight);
	}
}
