package com.tpsbackendsystem.controller;

 import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpsbackendsystem.model.Ticket;

//Server Path: http://localhost:8787
//RESTful APIs
@RestController
public class TicketController { //make the controller RestController

	/*
	 * Get api for fetching tickets
	 */
	@GetMapping("/get/ticket")  //api-url
	public List<Ticket> getTicketData(){
		Ticket ticket = new Ticket();
		ticket.setIssuer("harry potter");
		ticket.setDescription("My Laptop hangs, can you help!!");
		ticket.setId(1L);
		
		Ticket ticket1 = new Ticket();
		ticket1.setIssuer("ronald weasley");
		ticket1.setDescription("My Mobile hangs, can you help!!");
		ticket1.setId(2L);
		
		List<Ticket> list = new ArrayList<>();
		list.add(ticket);
		list.add(ticket1);
		
		return list;
	}
	
}
