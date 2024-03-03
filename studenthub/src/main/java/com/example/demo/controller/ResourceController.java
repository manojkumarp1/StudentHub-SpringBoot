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

import com.example.demo.model.Resources;
import com.example.demo.repositories.ResourcesRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ResourceController {
	
	@Autowired
	ResourcesRepo rrepo;
	
	@GetMapping("getResources")
	public ResponseEntity<Object> getResources()
	{
		List<Resources> resources=rrepo.findAll();
		
		
		return ResponseEntity.ok().body( 
				Map.of("Status", "Success","Result",resources)	
				);
	}
	
	@PostMapping("addResources")
	public ResponseEntity<Object> addResources(@RequestBody Resources r)
	{
		rrepo.save(r);
		
		
		return ResponseEntity.ok().body( 
				Map.of("status", "Success")	
				);
	}
}
