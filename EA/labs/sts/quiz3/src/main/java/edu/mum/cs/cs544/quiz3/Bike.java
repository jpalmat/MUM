package edu.mum.cs.cs544.quiz3;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle {

	private int numgears;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "pressure", column = @Column(name = "front_pressure")) })
	private Wheel front;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "pressure", column = @Column(name = "rear_pressure")) })
	private Wheel rear;
	
	
	
	public Bike(String owner, String make, String model, int year, String color, int numgears, Wheel front, Wheel rear) {
		super(owner, make, model, year, color);
		this.numgears = numgears;
		this.front = front;
		this.rear = rear;
	}

	public int getNumgears() {
		return numgears;
	}

	public void setNumgears(int numgears) {
		this.numgears = numgears;
	}

	public Wheel getFront() {
		return front;
	}

	public void setFront(Wheel front) {
		this.front = front;
	}

	public Wheel getRear() {
		return rear;
	}

	public void setRear(Wheel rear) {
		this.rear = rear;
	}
	
	
}