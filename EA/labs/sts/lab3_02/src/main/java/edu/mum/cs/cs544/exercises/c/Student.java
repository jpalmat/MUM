package edu.mum.cs.cs544.exercises.c;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	 @Id
    @GeneratedValue
    private int studentId;
    private String firstName;
    private String lastName;
    @ManyToMany
    Set<Course> courses = new HashSet<Course>();
    
	public Student() {
		super();
	}
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void addCourse (Course course) {
        this.courses.add(course);
    }
}
