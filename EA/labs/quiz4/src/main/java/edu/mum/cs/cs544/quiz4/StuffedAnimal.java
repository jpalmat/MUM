package edu.mum.cs.cs544.quiz4;

import javax.persistence.Entity;

@Entity
public class StuffedAnimal extends Toy {
	private String species;

	public StuffedAnimal(String description, String material, String color, String species) {
		super(description, material, color);
		this.species = species;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
}