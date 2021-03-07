package com.tpsbackendsystem.controller;

 import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tpsbackendsystem.model.Ticket;
import com.tpsbackendsystem.repository.TicketRepository;

//Server Path: http://localhost:8787
//RESTful APIs
@RestController
public class TicketController { //make the controller RestController

	@Autowired
	private TicketRepository ticketRepository;

	/*
	 * Take values from User and insert into DB 
	 * GET : POST : PUT : DELETE
	 * {
	 * 	  description: 'something...',
	 * 	  issuer : 'name of issuer'	
	 * }
	 * spring will convert this JSON object into Java Object using Jackson dependency
	 */
	@PostMapping("/ticket")
	public Ticket insertTicket(@RequestBody Ticket ticket){
		//using TicketRepository, insert ticket object. 
		return ticketRepository.save(ticket);
		
	}
	
}






