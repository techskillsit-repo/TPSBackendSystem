package com.tpsbackendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tpsbackendsystem.model.Executive;
import com.tpsbackendsystem.repository.ExecutiveRepository;

@RestController
public class ExecutiveController {

	@Autowired
	private ExecutiveRepository executiveRepository;
	
	@PostMapping("/executive")  
	public Executive insertExecitive(@RequestBody Executive executive){
		return executiveRepository.save(executive);
	}
	
	@GetMapping("/executives") 
	public void getAllExecutive(){
		 
	}
	
	@GetMapping("/executive/{id}")
	public Executive getSingleExecutive(@PathVariable("id") Long id){
		
	return executiveRepository.getOne(id);
		
	}
	
	@PutMapping("/executive/{id}")
	public void editExecutive(@RequestBody Executive executive){
		
	}
	
	@DeleteMapping("/executive/{id}")
	public void deleteExecutive(){
		
	}
	
	//everyone need to implement this and push the code in your respective branches without fail.
	
}
