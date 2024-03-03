package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Problems;
import com.example.demo.repositories.ProblemRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProblemController {
	
	
	@Autowired
	ProblemRepo prepo;
	
	@PostMapping("addProblem")
	private ResponseEntity<Object> addProblem(@RequestBody Problems p)
	{
		prepo.save(p);
		
		return ResponseEntity.ok().body( 
				Map.of("status", "Success","message", "problem added successfully.", "data", p)
				);
	}
	@GetMapping("getProblems")
	public ResponseEntity<Object> getProblem()
	{
		List<Problems> p=prepo.findAll();
		
		return ResponseEntity.ok().body( 
				Map.of("Status", "Success","Result",p)
				);
	}
	
	@PutMapping("updateStatus")
	private ResponseEntity<Object> updateStatus(@RequestBody Problems p)
	{
		Optional<Problems> problem=prepo.findById(p.getId());
		Problems prob = problem.get();
		prob.setStat(p.getStat());
		if(prepo.existsById(p.getId()))
		{
			prepo.save(prob);
			return ResponseEntity.ok().body(Map.of("success","true","message","Status updated successfully"));
		}
		else
		{
			return ResponseEntity.status(404).body(Map.of("success","false","message","application not found"));
			
		}
		
	}
	
	@PutMapping("updateSolution/{id}")
	private ResponseEntity<Object> updateSolution(@PathVariable("id")int id,@RequestBody Problems p)
	{
		
		Optional<Problems> problem=prepo.findById(id);
		Problems prob = problem.get();
		prob.setSolution(p.getSolution());
		if(prepo.existsById(id))
		{
			prepo.save(prob);
			return ResponseEntity.ok().body(Map.of("success","true","message","Solution updated successfully"));
		}
		else
		{
			return ResponseEntity.status(404).body(Map.of("success","false","message","application not found"));
			
		}
	}
	
	@DeleteMapping("deleteProblem/{id}")
	private ResponseEntity<Object> deleteProblem(@PathVariable("id") int id)
	{
		prepo.deleteById(id);
		return ResponseEntity.ok().body(Map.of("Status","Success","message","Problem Deleted successfully"));
	}
	
	

}
