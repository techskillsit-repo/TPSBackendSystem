package com.tpsbackendsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tpsbackendsystem.model.Ticket;
import com.tpsbackendsystem.service.TicketService;


@SpringBootTest
class TpsBackendSystemApplicationTests {

	@Autowired
	private TicketService ticketservice;

	@Test
	void testSum() {
		assertEquals(7, ticketservice.sum(4, 3));
	}

	@Test
	void testFetchTicketCustomerbyemail() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		List<Ticket> list = new ArrayList<>();
		
		list.add(new Ticket(1L, "Something", LocalDate.now(), "engineer", "Open"));
		list.add(new Ticket(2L, "rishi", LocalDate.now(), "resolved", "closed"));
		
		Mockito.when(ticketServiceMock.fetchTicketByCustEmail("Jha.rishi16@gmail")).thenReturn(list);
		
		
		assertEquals(2, ticketServiceMock.fetchTicketByCustEmail("Jha.rishi16@gmail").size());

	}
	
	@Test
	void testFetchTicketCustomerbymobile() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		List<Ticket> list = new ArrayList<>();
		
		list.add(new Ticket(1L, "Something", LocalDate.now(), "engineer", "Open"));
		list.add(new Ticket(2L, "rishi", LocalDate.now(), "resolved", "closed"));
		
		Mockito.when(ticketServiceMock.fetchTicketByCustMobile("9000671328")).thenReturn(list);
		
		
		assertEquals(2, ticketServiceMock.fetchTicketByCustMobile("9000671328").size());

	}


}
