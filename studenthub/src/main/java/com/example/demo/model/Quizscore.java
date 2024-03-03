package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Quizscore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizid;
	private String title;
	private String score;
	private String correctans;
	private String wrongans;
	private int student;
	
	

}
