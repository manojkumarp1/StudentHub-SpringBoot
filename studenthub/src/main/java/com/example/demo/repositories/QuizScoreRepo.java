package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Quizscore;
	
public interface QuizScoreRepo extends JpaRepository<Quizscore, Integer> {
	
	List<Quizscore> findByStudent(int student);
	

}