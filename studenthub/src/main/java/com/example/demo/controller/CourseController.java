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

import com.example.demo.model.Courses;
import com.example.demo.repositories.CourseRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CourseController {
	
	@Autowired
	CourseRepo crepo;
	
	@GetMapping("getCourses")
	public ResponseEntity<Object> getCourses()
	{
		List<Courses> courses=crepo.findAll();
		
		
		return ResponseEntity.ok().body( 
				Map.of("Status", "Success","Result",courses)
				);
	}
	
	@GetMapping("getCourse/{id}")
	public ResponseEntity<Object> getCourse(@PathVariable("id")int id)
	{
		
		
		if (crepo.existsById(id))
		{
			Optional<Courses> course=crepo.findById(id);
			
			return ResponseEntity.ok().body( 
					Map.of("Status", "Success","Result",course)
					);
		}
		else
		{
			return ResponseEntity.status(404).body( 
					Map.of("Error","Course not found")
					);
			
		}
	}

	@PostMapping("addCourse")
	private ResponseEntity<Object> addCourse(@RequestBody Courses c)
	{
		crepo.save(c);
		
		return ResponseEntity.ok().body( 
				Map.of("Status", "Success")
				);
		
		
	}
	@DeleteMapping("deleteCourse/{id}")
	private ResponseEntity<Object> deleteCourse(@PathVariable("id")int id)
	{
		

        if (crepo.existsById(id)) {
            crepo.deleteById(id);

            return ResponseEntity.ok().body(
                    Map.of("Status", "Success")
            );
        } else {
            return ResponseEntity.status(404).body(
                    Map.of("Status", "Failure", "Message", "Course not found")
            );
        }
		
	}
	
	@PutMapping("updateCourse/{id}")
	private ResponseEntity<Object> updateCoure(@PathVariable("id")int id,@RequestBody Courses course)
	{
		if(crepo.existsById(id))
		{
			crepo.save(course);
			return ResponseEntity.ok().body(Map.of("Status","Success"));
		}
		else
		{
	        return ResponseEntity.status(404).body(
	                 Map.of("Status", "Error", "Message", "Course not found"));       
			
		}
		
	}
	
	
}
