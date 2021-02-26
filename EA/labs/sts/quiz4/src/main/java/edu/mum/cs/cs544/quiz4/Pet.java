package edu.mum.cs.cs544.quiz4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name = "Birth")
public class Pet {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String species;
	private String gender;
	@Column(table = "Birth")
	private Date birthDate;
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Person person;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "Pet_id")
	private List<Toy> toys = new ArrayList<Toy>();
	
	
	public Pet() {
		super();
	}


	public Pet(String name, String species, String gender, Date birthDate) {
		super();
		this.name = name;
		this.species = species;
		this.gender = gender;
		this.birthDate = birthDate;
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


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public List<Toy> getToys() {
		return toys;
	}


	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}
	
	public void addToy(Toy toy) {
		this.toys.add(toy);
	}
	
}
