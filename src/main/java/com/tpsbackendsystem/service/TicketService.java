package com.tpsbackendsystem.service;

import java.util.List;
import java.util.stream.Collectors;

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
}
