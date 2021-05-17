package com.example.demo.model;

public class User {
	private String name;
	private String dep;
	private Long salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", dep=" + dep + ", salary=" + salary + "]";
	}
	
	
}
