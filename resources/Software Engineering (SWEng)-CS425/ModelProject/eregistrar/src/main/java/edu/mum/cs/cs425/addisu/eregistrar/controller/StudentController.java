package edu.mum.cs.cs425.addisu.eregistrar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.addisu.eregistrar.model.Student;
import edu.mum.cs.cs425.addisu.eregistrar.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// DISPLAY List Use-Case
	@GetMapping(value = { "/eRegistrar/student/list" })
	public ModelAndView listStudents(@RequestParam(defaultValue = "0") int pageno) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", studentService.getAllStudents());
		modelAndView.addObject("currentPageNo", pageno);
		modelAndView.setViewName("student/list");
		return modelAndView;
	}

	// Display form for Edit
	@GetMapping(value = { "/eRegistrar/student/edit" })
	public String displayRegistrationStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/edit";
	}

	// ADD-NEW Use-Case
	@PostMapping(value = { "/eRegistrar/student/save" })
	public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/eRegistrar/student/edit";
		}
		student = studentService.saveStudent(student);
		return "redirect:/eRegistrar/student/list";
	}

	// EDIT and then -> UPDATE Use-Case
	@GetMapping(value = { "/eRegistrar/student/update" })
	public String editStudent(@RequestParam Integer studentId, Model model) {
		Student student = studentService.getStudentById(studentId);
		if (student != null) {
			model.addAttribute("student", student);
			return "student/edit";
		}
		return "student/list";
	}

	// DELETE Use-Case
	@GetMapping(value = { "/eRegistrar/student/delete" })
	public String deleteStudent(@RequestParam("studentId") Integer studentId, Model model) {
		studentService.deleteStudentById(studentId);
		return "redirect:/eRegistrar/student/list";
	}

	// SEARCH Use-Case
	@GetMapping(value = { "/eRegistrar/student/search" })
	public ModelAndView searchStudent(@RequestParam String search, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", studentService.search(search));
		modelAndView.setViewName("student/list");
		return modelAndView;
	}
}