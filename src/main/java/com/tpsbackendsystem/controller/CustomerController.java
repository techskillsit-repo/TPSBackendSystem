package com.tpsbackendsystem.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpsbackendsystem.model.Customer;
import com.tpsbackendsystem.repository.CustomerRepository;
import com.tpsbackendsystem.service.CustomerService;

@RestController
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public Customer insertCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(@RequestParam(name="page", required=false, defaultValue="0") Integer page,
										  @RequestParam(name="size", required=false, defaultValue="100") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return customerService.findAll(pageable);
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerByID(@PathVariable("id") Long id) {
		return customerService.getOne(id);
	}
	
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer updatedCustomer) {
//		Fetch customer using id
		Customer customerDB =  customerService.getOne(id);
		customerDB.setEmail(updatedCustomer.getEmail());
		customerDB.setMobile(updatedCustomer.getMobile());
		
//		save the changes
		
		return customerService.save(customerDB);
	}
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteById(id);
	}

}
