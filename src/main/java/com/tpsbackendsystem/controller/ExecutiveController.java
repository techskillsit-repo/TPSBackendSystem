package com.tpsbackendsystem.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tpsbackendsystem.model.Executive;

@RestController
public class ExecutiveController {

	
	@PostMapping("/executive")  
	public Executive postExecutive(@RequestBody Executive executive){
		return null;
	}
	
	@GetMapping("/executives") 
	public void getAllExecutive(){
		 
	}
	
	@GetMapping("/executive/{id}")
	public void getSingleExecutive(){
		
	}
	
	@PutMapping("/executive/{id}")
	public void editExecutive(@RequestBody Executive executive){
		
	}
	
	@DeleteMapping("/executive/{id}")
	public void deleteExecutive(){
		
	}
	
	//everyone need to implement this and push the code in your respective branches without fail.
	
}
