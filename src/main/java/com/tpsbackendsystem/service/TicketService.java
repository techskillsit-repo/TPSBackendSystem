package com.tpsbackendsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpsbackendsystem.model.Ticket;
import com.tpsbackendsystem.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public List<Ticket> fetchTicketByCustomerID(Long custID) {
		return ticketRepository.fetchTicketByCustomerID(custID);
		 
	}
	
	
	
	public List<Ticket> fetchTicketByCustEmail(String email) {
		// TODO Auto-generated method stub
		return ticketRepository.fetchTicketByCustEmail(email);
	}



	public List<Ticket> fetchTicketByCustMobile(String mobile ) {
		// TODO Auto-generated method stub
		return ticketRepository.fetchByCustMobile(mobile);
	}



	public List<Ticket> fetchTicketByCustCode(String code) {
		// TODO Auto-generated method stub
		return ticketRepository.fetchByCustCode(code);
	}
		 
	
	 

}
