package edu.mum.cs.cs544.exercises.a;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private int employeenumber;
	private String name;
	@ManyToOne
	private Department deparment;
	
	public Employee() {
		super();
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public int getEmployeenumber() {
		return employeenumber;
	}

	public void setEmployeenumber(int employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDeparment() {
		return deparment;
	}

	public void setDeparment(Department deparment) {
		this.deparment = deparment;
	}
}
