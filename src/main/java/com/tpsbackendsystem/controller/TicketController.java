package com.tpsbackendsystem.controller;

 import java.util.ArrayList;
import java.util.List;

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

import com.tpsbackendsystem.TicketDto.TicketDto;
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
	
	
	//service layer
	@Autowired
	private TicketService ticketService;
	
	/*
	 * Take values from User and insert into DB 
	 * GET : POST : PUT : DELETE
	 * {
	 * 	  description: 'something...',
	 * 	  issuer : 'name of issuer'	
	 * }
	 * spring will convert this JSON object into Java Object using Jackson dependency
	 */
	@PostMapping("/ticket/{cid}/{eid}")
	public void insertTicket(
			@PathVariable("cid") Long cid,
			@PathVariable("eid") Long eid,
			@RequestBody Ticket ticket){
		
		 //fetch Customer record from cid
		Customer customer = customerRepository.getOne(cid);
		//fetch executive record from eid
		Executive executive = executiveRepository.getOne(eid);
		
		//attach these 2 objects to ticket 
		ticket.setCustomer(customer);
		ticket.setExecutive(executive);
		
		//save this ticket in the DB
		 ticketRepository.save(ticket);
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
		return  ticketService.findAll(pageable);
	}
	
	@GetMapping("/ticket/{id}")
	public Ticket getSingleTicket(@PathVariable("id") Long id){
		return ticketService.getOne(id);
	}
	
	@PutMapping("/ticket/{id}") //reading as path
	public Ticket updateTicket(@PathVariable("id") Long id,@RequestBody Ticket newTicketInfo){
		//go to DB and fetch the info of the ticket given from ID
		Ticket ticketDB = ticketRepository.getOne(id);
		//update the info of ticketDB
		ticketDB.setDescription(newTicketInfo.getDescription());
		
		//save updated info in DB again
		return ticketService.save(ticketDB);
	}
	
	@DeleteMapping("/ticket") //http://localhost:8787/ticket?id=2
	public void deleteTicket(@RequestParam("id") Long id){ //reading as param
		ticketRepository.deleteById(id);
	}
	
	//given customer ID or email or mobile or code return all tickets
	@GetMapping("/ticket-info-id/{id}")
	public List<TicketDto> fetchTicketByCustomerID(@PathVariable("id") Long custID){
		//go to service 
		List<Ticket> listTicket = ticketService.fetchTicketByCustomerID(custID);
		List<TicketDto> listdto = new ArrayList<>();
		
		listTicket.stream().forEach(t -> {
			TicketDto dto = new TicketDto();
			dto.setId(t.getId());
			dto.setDescription(t.getDescription());
			dto.setActionTaken(t.getActionTaken());
			dto.setCreatedDate(t.getCreatedDate());
			dto.setStatus(t.getStatus());
			dto.setCustomerName(t.getCustomer().getName());
			dto.setCustomerEmail(t.getCustomer().getEmail());;
			listdto.add(dto);
			
			
			
		});
		
		//listdto = listdto.stream().filter(t->t.getStatus().equals("open")).collect(Collectors.toList());
			
		
		return listdto;
	}
	
	@GetMapping("/ticket-info-email/{email}")
	public List<TicketDto> fetchTicketByCustEmail(@PathVariable("email") String email){
		List<Ticket> listTicket = ticketService.fetchTicketByCustEmail(email);
		List<TicketDto> listdto = new ArrayList<>();
		
		listTicket.stream().forEach(t -> {
			TicketDto dto = new TicketDto();
			dto.setId(t.getId());
			dto.setDescription(t.getDescription());
			dto.setActionTaken(t.getActionTaken());
			dto.setCreatedDate(t.getCreatedDate());
			dto.setStatus(t.getStatus());
			dto.setCustomerName(t.getCustomer().getName());
			dto.setCustomerEmail(t.getCustomer().getEmail());
			listdto.add(dto);
			
			
			
		});
		
		//listdto = listdto.stream().filter(t->t.getStatus().equals("open")).collect(Collectors.toList());
			
		
		return listdto;
	
	}
	
	@GetMapping("/ticket-info-mobile/{mobile}")
	public void fetchTicketByCustomerMobile(@PathVariable("mobile") String mobile){
		List<Ticket> listTicket = ticketService.fetchTicketByCustMobile(mobile);
		List<TicketDto> listdto = new ArrayList<>();
		
		listTicket.stream().forEach(t -> {
			TicketDto dto = new TicketDto();
			dto.setId(t.getId());
			dto.setDescription(t.getDescription());
			dto.setActionTaken(t.getActionTaken());
			dto.setCreatedDate(t.getCreatedDate());
			dto.setStatus(t.getStatus());
			dto.setCustomerName(t.getCustomer().getName());
			dto.setCustomerEmail(t.getCustomer().getEmail());
			listdto.add(dto);
			
			
			
		});
		
	}
	
	@GetMapping("/ticket-info-code/{code}")
	public void fetchTicketByCustomerCode(@PathVariable("code") String code){
		//todo
		List<Ticket> listTicket = ticketService.fetchTicketByCustCode(code);
		List<TicketDto> listdto = new ArrayList<>();
		
		listTicket.stream().forEach(t -> {
			TicketDto dto = new TicketDto();
			dto.setId(t.getId());
			dto.setDescription(t.getDescription());
			dto.setActionTaken(t.getActionTaken());
			dto.setCreatedDate(t.getCreatedDate());
			dto.setStatus(t.getStatus());
			dto.setCustomerName(t.getCustomer().getName());
			dto.setCustomerEmail(t.getCustomer().getEmail());;
			listdto.add(dto);
			
			
			
		});
		
	}
}


		






















