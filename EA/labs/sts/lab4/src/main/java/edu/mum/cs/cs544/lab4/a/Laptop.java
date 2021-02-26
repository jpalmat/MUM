package edu.mum.cs.cs544.lab4.a;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	@GeneratedValue
	private int id;
	private String brand;
	private String type;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	public Laptop() {
		super();
	}
	public Laptop(String brand, String type) {
		super();
		this.brand = brand;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
