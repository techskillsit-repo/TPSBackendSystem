package com.tpsbackendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tpsbackendsystem.model.Customer;
import com.tpsbackendsystem.repository.CustomerRepository;

@RestController
public class CustomerController {

	//getALL
	//getByID
	//POST : done
	//PUT
	//DELETE
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/customer")
	public void insertCustomer(@RequestBody Customer customer){
		//insert customer in DB
		customerRepository.save(customer);
	}
	
	@GetMapping("/customers")
	public void getAllCustomer(){
		//insert customer in DB
		customerRepository.findAll();
	}
	
	@GetMapping("/customer/{id}")
		public void  getOne(@PathVariable("id") Long id) {
		customerRepository.getOne(id);
	}

}
