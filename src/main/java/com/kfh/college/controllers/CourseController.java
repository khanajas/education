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

import com.kfh.college.enity.Course;
import com.kfh.college.services.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}

	@PostMapping("/addCourses")
	public List<Course> addCourses(@RequestBody List<Course> course) {
		return courseService.createCourses(course);
	}

	@GetMapping("/getCourse/{id}")
	public Course getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}

	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses() {
		return courseService.getCourses();
	}
	
	@PutMapping("/updateCourse")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}

	@DeleteMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable Long id) {
		return courseService.deleteCourseById(id);
	}
}
