package com.tpsbackendsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tpsbackendsystem.model.Customer;
import com.tpsbackendsystem.model.Executive;
import com.tpsbackendsystem.model.Ticket;
import com.tpsbackendsystem.repository.CustomerRepository;
import com.tpsbackendsystem.repository.ExecutiveRepository;
import com.tpsbackendsystem.repository.TicketRepository;

@Service
public class TicketService {
  
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ExecutiveRepository executiveRepository;
	
	public List<Ticket> fetchTicketByCustomerID(Long custID){
		return ticketRepository.fetchTicketByCustomerID(custID);
	}
	
	public List<Ticket> fetchTicketByCustomerEmail(String custEMAIL){
		List <Ticket> listTickets= ticketRepository.fetchTicketByCustomerEmail(custEMAIL);
		listTickets = listTickets.stream().filter(t-> t.getStatus().equals("open")).collect(Collectors.toList());
		return listTickets;
	}

	public List<Ticket> fetchTicketByCustomerMobile(String custMN) {
		List <Ticket> listTickets= ticketRepository.fetchCustomerByCustomerMobile(custMN);
		listTickets = listTickets.stream().filter(t-> t.getStatus().equals("close")).collect(Collectors.toList());
		return listTickets;
		}

	public List<Ticket> fetchTicketByCustomerCode(String custCODE) {
        List <Ticket> listTickets = ticketRepository.fetchCustomerByCustomerCode(custCODE);
        listTickets = listTickets.stream().filter(t-> t.getStatus().equals("in progress")).collect(Collectors.toList());
        return listTickets;
	}
	
	
	public int sum(int x, int y) {
		return x+y;
	}

	public Ticket getSingleTicket(Long id) {
		return ticketRepository.getOne(id);
	}
	
	public void deleteTicket(Long id) {
		ticketRepository.deleteById(id);
	}
	
	public Ticket insertTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	public void insertTicket(Long cid, Long eid,Ticket ticket) {
		Customer customer = customerRepository.getOne(cid);
		Executive executive = executiveRepository.getOne(eid);
		
		ticket.setCustomer(customer);
		ticket.setExecutive(executive);
		
		ticketRepository.save(ticket);
	}
	
	public List <Ticket> getAllTickets(Integer page, Integer size){
		Pageable pageable = PageRequest.of(page, size); 
		return  ticketRepository.findAll(pageable).getContent();
	}
	
	public Ticket updateTicket(Long id, Ticket newTicketInfo) {
		//go to DB and fetch the info of the ticket given from ID
				Ticket ticketDB = ticketRepository.getOne(id);
				//update the info of ticketDB
				ticketDB.setDescription(newTicketInfo.getDescription());
				
				//save updated info in DB again
				return ticketRepository.save(ticketDB);
	}
}
