package com.kfh.college.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfh.college.enity.Course;
import com.kfh.college.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	public List<Course> createCourses(List<Course> course) {
		return courseRepository.saveAll(course);
	}

	public Course getCourseById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	public List<Course> getCourses() {
		return courseRepository.findAll();
	}
	
	public Course updateCourse(Course course) {
		Course oldCourse=null;
		Optional<Course> optionalCourse=courseRepository.findById(course.getId());
		if(optionalCourse.isPresent()) {
			oldCourse=optionalCourse.get();
			oldCourse.setName(course.getName());
			courseRepository.save(oldCourse);
		}else {
			return new Course();
		}
		return oldCourse;
	}
	
	public String deleteCourseById(Long id) {
		courseRepository.deleteById(id);
		return "Course got deleted";
	}

}
