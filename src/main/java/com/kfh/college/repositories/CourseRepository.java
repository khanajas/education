package com.kfh.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kfh.college.enity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
