package edu.mum.cs.cs425.addisu.eregistrar.service;

import java.util.List;

import org.springframework.data.domain.Page;

import edu.mum.cs.cs425.addisu.eregistrar.model.Student;

public interface StudentService {

	public abstract Iterable<Student> getAllStudents();

	public abstract Page<Student> gettAllStudentsPaged(int pageno);

	public abstract Student saveStudent(Student student);

	public abstract Student getStudentById(Integer studentId);

	public abstract void deleteStudentById(Integer studentId);

	public abstract List<Student> search(String search);

}
