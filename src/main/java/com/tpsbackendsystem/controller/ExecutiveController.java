package com.tpsbackendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpsbackendsystem.model.Executive;
import com.tpsbackendsystem.model.Ticket;
import com.tpsbackendsystem.repository.ExecutiveRepository;

@RestController
public class ExecutiveController {

	@Autowired
	private ExecutiveRepository executiveRepository;
	
	@PostMapping("/executive")  
	public Executive insertExecutive(@RequestBody Executive executive){
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
	public Executive editExecutive(@PathVariable("id") Long id,@RequestBody Executive executive){
		
		Executive executiveDB = executiveRepository.getOne(id);
		executiveDB.setDepartment(executive.getDepartment());
		return executiveRepository.save(executiveDB);
	}
	
	@DeleteMapping("/executive/{id}")
	public void deleteExecutive(@RequestParam("id") Long id){
		executiveRepository.deleteById(id);
	}
	
	//everyone need to implement this and push the code in your respective branches without fail.
	
}
