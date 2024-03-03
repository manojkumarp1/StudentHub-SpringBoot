package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Courses;

public interface CourseRepo extends JpaRepository<Courses,Integer>{
	

}
