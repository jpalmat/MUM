package edu.mum.cs.cs544.quiz4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Toy {
	@Id
	@GeneratedValue
	private int id;
	private String description;
	private String material;
	private String color;
	
	public Toy() {
		super();
	}

	public Toy(String description, String material, String color) {
		super();
		this.description = description;
		this.material = material;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}