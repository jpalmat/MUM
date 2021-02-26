package edu.mum.cs.cs544.quiz3;

import javax.persistence.Embeddable;

@Embeddable
public class Wheel {
	private double pressure;

	public Wheel(double pressure) {
		super();
		this.pressure = pressure;
	}

	public Wheel() {
		super();
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
}