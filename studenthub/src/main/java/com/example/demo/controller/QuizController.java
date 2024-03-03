package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Quizscore;
import com.example.demo.repositories.QuizScoreRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class QuizController {
	
	@Autowired
	QuizScoreRepo qrepo;
	
	@GetMapping("/game")
	private ResponseEntity<Object> gameDetails(@RequestParam int studentId )
	{

		List<Quizscore> q = qrepo.findByStudent(studentId);
		
		return ResponseEntity.ok().body(q);
		
	}	
	
	@PostMapping("storeGameData")
	private ResponseEntity<Object> addData(@RequestBody Quizscore q)
	{
		qrepo.save(q);	
		
		return ResponseEntity.status(200).body( 
				Map.of("message","Game data stored successfully")
				);
		
		
	}
	
}
