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
	
	public List<Ticket> fetchTicketByCustomerID(Long custID){
		return ticketRepository.fetchTicketByCustomerID(custID);
	}
	
	public List<Ticket> fetchTicketByCustomerEmail(String custEMAIL){
		return ticketRepository.fetchTicketByCustomerEmail(custEMAIL);
	}

	public List<Ticket> fetchTicketByCustomerMobile(String custMN) {
		return ticketRepository.fetchCustomerByCustomerMobile(custMN);
	}

	public List<Ticket> fetchTicketByCustomerCode(String custCODE) {
		return ticketRepository.fetchCustomerByCustomerCode(custCODE);

	}
}
