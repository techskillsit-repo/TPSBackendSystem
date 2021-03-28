package com.tpsbackendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpsbackendsystem.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}