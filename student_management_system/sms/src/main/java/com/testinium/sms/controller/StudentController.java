package com.testinium.sms.controller;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.testinium.sms.domain.Student;
import com.testinium.sms.service.StudentService;

@RestController
@RequestScope
@RequestMapping("students")
@CrossOrigin
@Validated
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
//	List all students
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

//	add student
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

//	save student
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

//	update student from page
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable String id, Model model) {
		Student existingStudent = studentService.getStudentById(id);
		model.addAttribute("student", existingStudent);
		return "edit_student";
	}


//	update student actual 
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable String id, 
								@ModelAttribute("student") Student student, 
								Model model) {
	
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setStudentId(student.getStudentId());
		existingStudent.setName(student.getName());
	
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	
//	delete student
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}

}
