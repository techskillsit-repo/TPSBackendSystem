package com.tpsbackendsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
		 
	public int sum(int x, int y) {
		return x+y;
	}



	public List<Ticket> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return  ticketRepository.findAll(pageable).getContent();
	}



	public Ticket getOne(Long id) {
		// TODO Auto-generated method stub
		return ticketRepository.getOne(id);
	}



	public Ticket save(Ticket ticketDB) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticketDB);
	}
	 

}
