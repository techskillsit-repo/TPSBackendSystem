package com.tpsbackendsystem.controller;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	//getALL
	//getByID
	//POST : done
	//PUT
	//DELETE
	@Autowired
	private CustomerRepository customerRepository;
	private CustomerService customerservice;
	
	@PostMapping("/customer")
	public void insertCustomer(@RequestBody Customer customer){
		//insert customer in DB
		customerRepository.save(customer);
			customerservice.save(customer);
		}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer(@RequestParam(name="page", required=false, defaultValue="0") Integer page,
			  @RequestParam(name="size", required=false, defaultValue="100") Integer size){
		Pageable pageable =  (Pageable) PageRequest.of(page, size);
		return customerservice.findAll(pageable);

	}
	
	@GetMapping("/customer/{id}")
		public Customer getOne(@PathVariable("id") Long id) {
		return customerservice.getOne(id);
	}
	
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer) {
		Customer customerDB = customerservice.getOne(id);
		customerDB.setName(customer.getName());
		customerDB.setEmail(customer.getEmail());
		return customerservice.save(customerDB);
	}

}
