package edu.mum.cs.cs425.addisu.eregistrar.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.addisu.eregistrar.model.Student;
import edu.mum.cs.cs425.addisu.eregistrar.repository.StudentRepository;
import edu.mum.cs.cs425.addisu.eregistrar.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	EntityManager entity;

	@Autowired
	private StudentRepository repository;

	@Override
	public Iterable<Student> getAllStudents() {
		return repository.findAll(Sort.by("firstName"));
	}

	@Override
	public Page<Student> gettAllStudentsPaged(int pageno) {

		return repository.findAll(PageRequest.of(pageno, 5, Sort.by("title")));
	}

	@Override
	public Student saveStudent(Student student) {

		return repository.save(student);
	}

	@Override
	public Student getStudentById(Integer studentId) {
		return repository.findById(studentId).orElse(null);
	}

	@Override
	public void deleteStudentById(Integer studentId) {
		repository.deleteById(studentId);
	}

	@Override
	public List<Student> search(String search) {
		List<Student> students = repository.findStudentByStudentNumberOrFirstNameOrLastName(search, search, search);
		return students;
	}

}
