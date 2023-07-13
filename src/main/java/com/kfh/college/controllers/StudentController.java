package com.kfh.college.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kfh.college.enity.Student;
import com.kfh.college.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		
		return studentService.createStudent(student);
		
	}
	
	
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
				
	}
	
	@PutMapping("/updateCoursesForStudent")
	public Student updateCoursesForStudent(@RequestBody Student student) {
	
		return studentService.updateCourseForStudent(student);
	}
	
	@DeleteMapping("/deletStudent/{id}")
	public String delete(@PathVariable Long id) {
		return studentService.createStudent(id);
	}
	
}
