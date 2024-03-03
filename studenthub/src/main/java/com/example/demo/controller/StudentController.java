package com.example.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Courses;
import com.example.demo.model.Students;
import com.example.demo.repositories.StudentRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {

	@Autowired
	StudentRepo srepo;
	
	
	
	@PostMapping("login")
	public ResponseEntity<Object> login(@RequestBody Students s)
	{
		Students student = srepo.findByEmailAndPassword(s.getEmail(),s.getPassword());
		
		 if (student != null) {
			 
	            return ResponseEntity.ok().body(
	                Map.of("Status", "Success", "studentId", student.getId())
	            );
	        } else 
	            return ResponseEntity.status(401).body(
	                Map.of("Status", "Failure", "Message", "Invalid email or password")
	            );
	}
	
	@PostMapping("signup")
	public ResponseEntity<Object> signup(@RequestBody Students s )
	{
		
		Students student = srepo.save(s);
		
		if(student != null)
		{
			return ResponseEntity.ok().body(student);
			
		}
		else
		{
			return ResponseEntity.status(500).body(
	                Map.of("Status", "Failure", "Message", "Error during signup")
	            );
		}
		
	}
	
	@GetMapping("students/{id}")
	private ResponseEntity<Object> getStudent(@PathVariable("id") int id)
	{
		if (srepo.existsById(id))
		{
			Optional<Students> s=srepo.findById(id);
			
			return ResponseEntity.ok().body( 
					Map.of("Status", "Success","data",s)
					);
		}
		else
		{
			return ResponseEntity.status(404).body( 
					Map.of("Status","Not Found")
					);
			
		}
		
	}
	
	@PutMapping("students/{id}")
	private ResponseEntity<Object> updateStudents(@PathVariable("id")int id,@RequestBody Students s)
	{
		if(srepo.existsById(id))
		{
			srepo.save(s);
			return ResponseEntity.ok().body(Map.of("Status","Success"));
		}
		else
		{
	        return ResponseEntity.status(404).body(
	                 Map.of("Status", "Error", "Message", "Course not found"));
		}
		
		
		
	}

}
