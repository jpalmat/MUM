package edu.mum.cs.cs544.quiz3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SecondaryTable(name = "Owners", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id") })
public class Vehicle {

	@Id
	@GeneratedValue
	private int id;

	@Column(table = "Owners")
	private String owner;
	@Column(length = 255)
	private String make;
	@Column(length = 255)
	private String model;
	private int year;
	@Column(length = 255)
	private String color;
	
	public Vehicle(String owner, String make, String model, int year, String color) {
		super();
		this.owner = owner;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
	}
	
	public Vehicle() {
		super();
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	

}
