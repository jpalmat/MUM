package edu.mum.cs.cs544.lab4.a;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
	private Set<Laptop> laptopList = new HashSet<Laptop>();
	
	public Student() {
	}

	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Laptop> getLaptopList() {
		return laptopList;
	}

	public void setLaptopList(Set<Laptop> laptopList) {
		this.laptopList = laptopList;
	}
	
	public void addLaptop(Laptop laptop) {
		laptop.setStudent(this);
		this.laptopList.add(laptop);
	}
}
