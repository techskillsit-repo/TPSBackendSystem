package com.tpsbackendsystem.controller;

 import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets(
			@RequestParam(name="page",required=false, defaultValue="0") Integer page, 
			@RequestParam(name="size",required=false,defaultValue="100") Integer size){
		
		Pageable pageable = PageRequest.of(page, size); 
		return  ticketRepository.findAll(pageable).getContent();
	}
	
	@GetMapping("/ticket/{id}")
	public Ticket getSingleTicket(@PathVariable("id") Long id){
		return ticketRepository.getOne(id);
	}
	
	@PutMapping("/ticket/{id}") //reading as path
	public Ticket updateTicket(@PathVariable("id") Long id,@RequestBody Ticket newTicketInfo){
		//go to DB and fetch the info of the ticket given from ID
		Ticket ticketDB = ticketRepository.getOne(id);
		//update the info of ticketDB
		ticketDB.setDescription(newTicketInfo.getDescription());
		
		//save updated info in DB again
		return ticketRepository.save(ticketDB);
	}
	
	@DeleteMapping("/ticket") //http://localhost:8787/ticket?id=2
	public void deleteTicket(@RequestParam("id") Long id){ //reading as param
		ticketRepository.deleteById(id);
	}
}


//Executive
/*
 * 1. create Entity (id, name, department) : Rutvij (2 mins)
 * 2. create Repo for Entity : ExecutiveRepository : Tejal (2 mins)
 * 3. create Controller for Entity : (ExecutiveController) : (1min)
 * 	3.1 GET API: single executive : (Madhavi)
 * 	3.2 GET API: for all executives (Richa)
 *  3.3 POST API for single executive : (Deep)
 *  3.4 PUT API: for updating executive info(only department update): Rutvij
 *  3.5 DELETE API: for single delete (Mandar)
 */
		






















