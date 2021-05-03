package edu.mum.cs.cs425.eregistrar.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Integer studentId;
    private String name;
    private Float cgpa;

    @Column(name="admission_date")
    private LocalDate admissionDate;

    public Student() {
    }

    public Student(Integer studentId, String name, Float cgpa, LocalDate admissionDate) {
        this.studentId = studentId;
        this.name = name;
        this.cgpa = cgpa;
        this.admissionDate = admissionDate;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
}
