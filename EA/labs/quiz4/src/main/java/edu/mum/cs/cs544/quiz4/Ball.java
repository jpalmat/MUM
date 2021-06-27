package edu.mum.cs.cs544.quiz4;

import javax.persistence.Entity;

@Entity
public class Ball extends Toy {
    private int Size;

	public Ball(String description, String material, String color, int size) {
		super(description, material, color);
		this.Size = size;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}
}