package edu.mum.cs.cs544.lab4.c;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class School {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="school_id")
	@MapKey(name = "studentId")
    Map<Integer, Student1> studentMap = new HashMap<Integer, Student1>();
	
	public School() {
		super();
	}
	
	public School(String name) {
		super();
		this.name = name;
	}

	public Map<Integer, Student1> getStudentMap() {
		return studentMap;
	}

	public void setStudentMap(Map<Integer, Student1> studentMap) {
		this.studentMap = studentMap;
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
	
	public void addMapStudent(Student1 student) {
		this.studentMap.put(student.getStudentId(), student);
	}
	
}
