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

import com.tpsbackendsystem.model.Customer;
import com.tpsbackendsystem.model.Executive;
import com.tpsbackendsystem.model.Ticket;
import com.tpsbackendsystem.repository.CustomerRepository;
import com.tpsbackendsystem.repository.ExecutiveRepository;
import com.tpsbackendsystem.repository.TicketRepository;
import com.tpsbackendsystem.service.TicketService;

//Server Path: http://localhost:8787
//RESTful APIs
@RestController
public class TicketController { //make the controller RestController

	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ExecutiveRepository executiveRepository;

	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/ticket/{cid}/{eid}")
	public void insertTicket(
			@PathVariable("cid") Long cid,
			@PathVariable ("eid") Long eid,
			@RequestBody Ticket ticket) {
		
		
		Customer customer = customerRepository.getOne(cid);
		Executive executive = executiveRepository.getOne(eid);
		
		ticket.setCustomer(customer);
		ticket.setExecutive(executive);
		
		ticketRepository.save(ticket);
	}
	
	
	
	
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
	
////	Now we will work with paging that we see in google or amazon when we click next page we don't see all the items we only see a limited items on a single page so that the db doesn't breakdown when retrieving the items
//	@GetMapping("/tickets/{page}/{size}")
//	public List<Ticket> getAllTickets(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
//		Pageable pageable = PageRequest.of(page, size);
////		Pageable is an interface.
////		PageRequest is an abstract class which has a static method "of"
//		return ticketRepository.findAll(pageable).getContent(); //Since our return type is a List<Ticket> we need to convert the Pageable type to a List using getContent()
////		jpaRepository provides us with a findAll() method and also findAll() method with an argument for Pageable interface
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

  @GetMapping("/ticket-info-id/{id}")
    public List<Ticket> fetchTicketByCustomerID(@PathVariable("id") Long custID){
    	List<Ticket> ticket = ticketService.fetchTicketByCustomerID(custID);
    	return ticket;
    }
  
  @GetMapping("/ticket-info-email/{email}")
	public List<Ticket> fetchTicketByCustomerEmail(@PathVariable("email") String custEMAIL){
	  List<Ticket> ticket =ticketService.fetchTicketByCustomerEmail(custEMAIL);
	  return ticket;
		
	}
 
  @GetMapping("/ticket-info-mobile/{mobile}")
	public List<Ticket> fetchTicketByCustomerMobile(@PathVariable("mobile") String custMN){
		List<Ticket> ticket= ticketService.fetchTicketByCustomerMobile(custMN);
		return ticket;
	}
	
	@GetMapping("/ticket-info-code/{code}")
	public List<Ticket> fetchTicketByCustomerCode(@PathVariable("code")String custCODE){
		List<Ticket> ticket =ticketService.fetchTicketByCustomerCode(custCODE);
		return ticket;
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
		






















