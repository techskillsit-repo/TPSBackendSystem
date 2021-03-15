package com.tpsbackendsystem.controller;

import java.util.List;

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
	
    @GetMapping("/exceutive/{id}")
	public Executive getSingleExe(@PathVariable("id") Long id) {
      return executiveRepository.getOne(id);
	}
    @GetMapping("/executives")
    public List<Executive> getAllExe(){
    	return executiveRepository.findAll();
    }
    
    @PostMapping("/executive")
    public Executive addExe(@RequestBody Executive executive) {
    	return executiveRepository.save(executive);
    
    }
    
    @PutMapping("executive/{id}")
    public Executive updateExe(@PathVariable("Id") Long id, @RequestBody Executive executive) {
    	Executive executiveDB = executiveRepository.getOne(id);
    	executiveDB.setDepartment(executive.getDepartment());
    	executiveDB.setName(executive.getName());
    	return executiveRepository.save(executiveDB);
    }
    
    
    @DeleteMapping("executive/{id}")
    public void deleteExe(@PathVariable("id") Long id) {
    	executiveRepository.deleteById(id);
    }
    
}
