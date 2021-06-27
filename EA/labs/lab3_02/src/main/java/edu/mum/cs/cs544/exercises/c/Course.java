package edu.mum.cs.cs544.exercises.c;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
    @GeneratedValue
    private int id;
    private int courseNumber;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<Student>();
    
	public Course() {
		super();
	}

	public Course(int courseNumber, String name) {
		super();
		this.courseNumber = courseNumber;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	 public void addStudent (Student student) {
        this.students.add(student);
    }
}
