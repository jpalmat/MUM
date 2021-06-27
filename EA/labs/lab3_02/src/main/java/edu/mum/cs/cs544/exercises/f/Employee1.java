package edu.mum.cs.cs544.exercises.f;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee1 {
	
	@Id
	@GeneratedValue
	private int employeenumber;
	private String name;
	@ManyToOne(cascade=CascadeType.ALL)
	private Department1 deparment;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="office")
    private Office office;
	
	public Employee1() {
		super();
	}

	public Employee1(String name) {
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

	public Department1 getDeparment() {
		return deparment;
	}

	public void setDeparment(Department1 deparment) {
		this.deparment = deparment;
	}
	
	public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
