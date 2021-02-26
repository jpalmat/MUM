package edu.mum.cs.cs544.exercises.f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department1 {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy="deparment")
	private List<Employee1> employees = new ArrayList<Employee1>();
	
	public Department1() {
		super();
	}

	public Department1(String name) {
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
	
	public void addEmployee(Employee1 employee) {
		employees.add(employee);
	}
}
