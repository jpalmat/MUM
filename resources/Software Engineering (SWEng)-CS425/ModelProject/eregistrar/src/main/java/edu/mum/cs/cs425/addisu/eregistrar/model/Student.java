package edu.mum.cs.cs425.addisu.eregistrar.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "*Student number is required")
	private String studentNumber;

	@NotBlank(message = "*First name is required")
	private String firstName;

	private String middleName;
	@NotBlank(message = "*Last name is required")

	private String lastName;

	private double cgpa;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate enrollmentDate;

	@NotBlank(message = "*Are you international field is required")
	private String isInternational;

	public Student() {
	}

	public Student(Integer id, @NotBlank(message = "*Student number is required") String studentNumber,
			@NotBlank(message = "*First name is required") String firstName, String middleName,
			@NotBlank(message = "*Last name is required") String lastName, double cgpa,
			@NotBlank(message = "*Enrollment date is required") LocalDate enrollmentDate,
			@NotBlank(message = "*Are you international field is required") String isInternational) {

		this.id = id;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.enrollmentDate = enrollmentDate;
		this.isInternational = isInternational;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(String isInternational) {
		this.isInternational = isInternational;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentNumber=" + studentNumber + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", cgpa=" + cgpa + ", enrollmentDate=" + enrollmentDate
				+ ", isInternational=" + isInternational + "]";
	}
}