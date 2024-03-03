package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Resources;

public interface ResourcesRepo extends JpaRepository<Resources,Integer>{

}
