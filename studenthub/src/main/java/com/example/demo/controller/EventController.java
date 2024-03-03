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

import com.example.demo.model.Events;
import com.example.demo.repositories.EventRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventController {
	
	@Autowired
	EventRepo erepo;
	
	@PostMapping("addEvents")		
	private ResponseEntity<Object> addEvent(@RequestBody Events e)
	{
		
		erepo.save(e);
		
		return ResponseEntity.ok().body(e);
				
	}
	
	@GetMapping("/events")
	private ResponseEntity<Object> events()
	{
			
		List<Events> events = erepo.findAll();
		
		return ResponseEntity.ok().body(Map.of("Status","Success","Result",events));
				
	}
	
	
	
	
}
