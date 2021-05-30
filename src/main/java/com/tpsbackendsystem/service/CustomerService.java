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



public Customer save(Customer customer) {
	return customerRepository.save(customer);
	// TODO Auto-generated method stub
	
}




public List<Customer> findAll(Pageable pageable) {
	// TODO Auto-generated method stub
	return customerRepository.findAll();
}




public Customer getOne(Long id) {
	// TODO Auto-generated method stub
	return customerRepository.getOne(id);
	
	
}

}
