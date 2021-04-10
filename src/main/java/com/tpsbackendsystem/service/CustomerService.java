package com.tpsbackendsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tpsbackendsystem.model.Customer;
import com.tpsbackendsystem.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer getOne(Long cid) {
		Customer customer = customerRepository.getOne(cid);
		return customer;
	}

	public List<Customer> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable).getContent();
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}

}
