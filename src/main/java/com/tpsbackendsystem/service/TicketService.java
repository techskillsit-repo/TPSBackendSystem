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
//		Go to ticketRepository
		return ticketRepository.fetchTicketByCustomerID(custID);
	}

	public List<Ticket> fetchTicketByCustomerEmail(String email) {
//		Go to ticketRepository
		return ticketRepository.fetchTicketByCustomerEmail(email);
	}

	public List<Ticket> fetchTicketByCustomerMobile(String mobile) {
//		Go to ticketRepository
		return ticketRepository.fetchTicketByCustomerMobile(mobile);
	}

	public List<Ticket> fetchTicketByCustomerCode(String code) {
//		Go to ticketRepository
		return ticketRepository.fetchTicketByCustomerCode(code);
	}

}
