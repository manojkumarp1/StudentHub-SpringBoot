package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Enroll;
import com.example.demo.repositories.EnrollRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EnrollController {
	
	@Autowired
	EnrollRepo erepo;
	
	@PostMapping("enrollCourse")
	private ResponseEntity<Object> enroll(@RequestBody Enroll e)
	{
		erepo.save(e);
		
		return ResponseEntity.ok().body( 
				Map.of("status", "Success","message", "problem added successfully.", "data", e)
				);
	}
	
	@GetMapping("progress")
	private ResponseEntity<Object> progress()
	{
		List<Enroll> e = erepo.findAll();
		return ResponseEntity.ok().body(
				Map.of("Status","Success","Result",e))
				;
	}

}
