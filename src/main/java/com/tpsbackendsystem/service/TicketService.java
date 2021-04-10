package com.tpsbackendsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tpsbackendsystem.dto.TicketDto;
import com.tpsbackendsystem.model.Ticket;
import com.tpsbackendsystem.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;

	public List<Ticket> fetchTicketByCustomerID(Long custID) {
//		Go to ticketRepository
		List<Ticket> listTicket = ticketRepository.fetchTicketByCustomerID(custID);
		listTicket = listTicket.stream().filter(t -> t.getStatus().equals("open")).collect(Collectors.toList());
		return listTicket;
	}

	public List<Ticket> fetchTicketByCustomerEmail(String email) {
//		Go to ticketRepository
		List<Ticket> listTicket = ticketRepository.fetchTicketByCustomerEmail(email);
		listTicket = listTicket.stream().filter(t -> t.getStatus().equals("open")).collect(Collectors.toList());
//		Filtering out the tickets with status = open and then collecting them back into the list named listDto
		return listTicket;
	}

	public List<Ticket> fetchTicketByCustomerMobile(String mobile) {
//		Go to ticketRepository
		List<Ticket> listTicket = ticketRepository.fetchTicketByCustomerMobile(mobile);
		listTicket = listTicket.stream().filter(t -> t.getStatus().equals("open")).collect(Collectors.toList());
		return listTicket;
	}

	public List<Ticket> fetchTicketByCustomerCode(String code) {
//		Go to ticketRepository
		List<Ticket> listTicket = ticketRepository.fetchTicketByCustomerCode(code);
		listTicket = listTicket.stream().filter(t -> t.getStatus().equals("open")).collect(Collectors.toList());
		return listTicket;
	}
	
	public int sum(int x, int y) {
		return x+y;
	}

	public List<Ticket> findAll(Pageable pageable) {
		List<Ticket> list = ticketRepository.findAll(pageable).getContent();
		return list;
	}

	public Ticket getOne(Long id) {
		return ticketRepository.getOne(id);
	}

	public Ticket save(Ticket ticketDB) {
		return ticketRepository.save(ticketDB);
	}

	public void deleteById(Long id) {
		ticketRepository.deleteById(id);
	}

}
