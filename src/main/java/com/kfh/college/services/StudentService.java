package com.kfh.college.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfh.college.enity.Student;
import com.kfh.college.exceptions.StudentNotFoundException;
import com.kfh.college.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudentById(Long id) {
		
		 if(!studentRepository.findById(id).isPresent()) {
			 throw new StudentNotFoundException("Student Not Found");
		 }
		 return studentRepository.findById(id).get();
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	
	
	public Student updateCourseForStudent(Student student){	
		System.out.println(student.getId());
		Student oldStudent = null;
		Optional<Student> findById = studentRepository.findById(student.getId());
	
		if(findById.isPresent()) {
			oldStudent=findById.get();
			oldStudent.setCourses(student.getCourses());
			studentRepository.save(oldStudent);

		}else {
			return new Student();
		}
		return oldStudent;
	}

	public String createStudent(Long id) {
		 studentRepository.deleteById(id);
		 return "Student got deleted";
	}
}
