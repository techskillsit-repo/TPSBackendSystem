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
import com.tpsbackendsystem.repository.TicketRepository;
import com.tpsbackendsystem.service.TicketService;


 
@SpringBootTest
class TpsBackendSystemApplicationTests {

	@Autowired
 
	private TicketService ticketService; 
	
	@Test
	void sampleTest() {
		int x = 2;
		int result = 3;
		assertEquals(2, 2);
	}
	
 
	@Test
	void testFetchTicketByCustomerEmail() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class); 
		TicketRepository tr = Mockito.mock(TicketRepository.class);
		List<Ticket> list = new ArrayList<>();
		list.add(new Ticket(1L, "something", LocalDate.now(), "referred to engineer", "open"));
		list.add(new Ticket(2L, "something", LocalDate.now(), "referred to tech support", "close"));
		
		List<Ticket> list1 = new ArrayList<>();
		list1.add(new Ticket(3L, "something", LocalDate.now(), "referred to engineer", "open"));
		
		Mockito.when(tr.fetchTicketByCustEmail("i.hirani@techskillsit.com"))
		.thenReturn(list);
		
		Mockito.when(tr.fetchTicketByCustEmail("i.hirani@gmail.com"))
		.thenReturn(list1);
		
		 
		assertEquals(1, ticketServiceMock.fetchTicketByCustEmail("i.hirani@techskillsit.com").size());
		//assertEquals(1, ticketServiceMock.fetchTicketByCustomerEmail("i.hirani@gmail.com").size());
	}
 
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
