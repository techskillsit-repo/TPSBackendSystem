package com.tpsbackendsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.creation.bytebuddy.MockAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.tpsbackendsystem.model.Customer;
import com.tpsbackendsystem.model.Executive;
import com.tpsbackendsystem.model.Ticket;
import com.tpsbackendsystem.service.CustomerService;
import com.tpsbackendsystem.service.ExecutiveService;
import com.tpsbackendsystem.service.TicketService;

@SpringBootTest
class TpsBackendSystemApplicationTests {

//	@Test
//	void contextLoads() {
//	}

//	We write our testcases inside src/test/java in this file
// We need to write different methods inside which we can use assertEquals and other methods for testing our logic
	
	@Autowired
	private TicketService ticketService;
//	Since we want to test our sum method present inside the TicketService class we are autowiring the reference so we don't need to create an object
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ExecutiveService executiveService;
	
	
//	TicketService testing
	
	@Test
	void testSum() {
		assertEquals(11, ticketService.sum(3, 8));
//		assertEquals takes 2 arguments: 1st is the expected value and 2nd is the actual value that we get. if equal in assertEquals then the test is passed
		assertNotEquals(7, ticketService.sum(4, -1));
//		assertNotEquals also takes 2 arguments: 1st is the expected value and 2nd is the actual value that we get. if not equal in assertNotEquals then the test is passed

//		There needs to be multiple assertEquals statements inside a method so that we can test all the extreme cases for our code
		
	}
	
	@Test
	void testFetchTicketByCustomerEmail() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		List<Ticket> list = new ArrayList<>();
		list.add(new Ticket(1L, "Something", LocalDate.now(), "Informed to the engineer", "open"));
		list.add(new Ticket(2L, "Something", LocalDate.now(), "Informed to the tech support", "close"));
		
		List<Ticket> list1 = new ArrayList<>();
		list1.add(new Ticket(3L, "Something else", LocalDate.now(), "Informed to the engineer", "open"));
		
		
		Mockito.when(ticketServiceMock.fetchTicketByCustomerEmail("rutvijdave@gmail.com"))
			   .thenReturn(list);
		
		Mockito.when(ticketServiceMock.fetchTicketByCustomerEmail("rutvijd@gmail.com"))
			   .thenReturn(list1);
		
		
		assertEquals(2, ticketServiceMock.fetchTicketByCustomerEmail("rutvijdave@gmail.com").size());
		assertEquals(1, ticketServiceMock.fetchTicketByCustomerEmail("rutvijd@gmail.com").size());
			
		
	}
	
	@Test
	void testFetchTicketByCustomerID() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		List<Ticket> list = new ArrayList<>();
		list.add(new Ticket(1L, "Something", LocalDate.now(), "Informed to the engineer", "open"));
		list.add(new Ticket(2L, "Something", LocalDate.now(), "Informed to the tech support", "close"));
		
		List<Ticket> list1 = new ArrayList<>();
		list1.add(new Ticket(3L, "Something else", LocalDate.now(), "Informed to the engineer", "open"));
		list1.add(new Ticket(4L, "Something new", LocalDate.now(), "Reported to the manager", "open"));
		list1.add(new Ticket(5L, "Working fine", LocalDate.now(), "Ticket closed", "close"));
		
		Mockito.when(ticketServiceMock.fetchTicketByCustomerID(1L))
			   .thenReturn(list);
		
		Mockito.when(ticketServiceMock.fetchTicketByCustomerID(2L))
			   .thenReturn(list1);
		
		assertEquals(2, ticketServiceMock.fetchTicketByCustomerID(1L).size());
		assertEquals(3, ticketServiceMock.fetchTicketByCustomerID(2L).size());
		
		
	}
	
	@Test
	void testFetchTicketByCustomerMobile() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		List<Ticket> list = new ArrayList<>();
		list.add(new Ticket(1L, "Something", LocalDate.now(), "Informed to the engineer", "open"));
		list.add(new Ticket(2L, "Something", LocalDate.now(), "Informed to the tech support", "close"));
		
		List<Ticket> list1 = new ArrayList<>();
		list1.add(new Ticket(3L, "Something else", LocalDate.now(), "Informed to the engineer", "open"));
		list1.add(new Ticket(4L, "Something new", LocalDate.now(), "Reported to the manager", "open"));
		list1.add(new Ticket(5L, "Working fine", LocalDate.now(), "Ticket closed", "close"));
		
		Mockito.when(ticketServiceMock.fetchTicketByCustomerMobile("9876543211"))
			   .thenReturn(list);
		
		Mockito.when(ticketServiceMock.fetchTicketByCustomerMobile("8765432191"))
			   .thenReturn(list1);
		
		assertEquals(2, ticketServiceMock.fetchTicketByCustomerMobile("9876543211").size());
		assertEquals(3, ticketServiceMock.fetchTicketByCustomerMobile("8765432191").size());
		
		
	}
	
	@Test
	void testFetchTicketByCustomerCode() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		List<Ticket> list = new ArrayList<>();
		list.add(new Ticket(1L, "Something", LocalDate.now(), "Informed to the engineer", "open"));
		list.add(new Ticket(2L, "Something", LocalDate.now(), "Informed to the tech support", "close"));
		
		List<Ticket> list1 = new ArrayList<>();
		list1.add(new Ticket(3L, "Something else", LocalDate.now(), "Informed to the engineer", "open"));
		list1.add(new Ticket(4L, "Something new", LocalDate.now(), "Reported to the manager", "open"));
		list1.add(new Ticket(5L, "Working fine", LocalDate.now(), "Ticket closed", "close"));
		
		Mockito.when(ticketServiceMock.fetchTicketByCustomerCode("1234"))
			   .thenReturn(list);
		
		Mockito.when(ticketServiceMock.fetchTicketByCustomerCode("4321"))
			   .thenReturn(list1);
		
		assertEquals(2, ticketServiceMock.fetchTicketByCustomerCode("1234").size());
		assertEquals(3, ticketServiceMock.fetchTicketByCustomerCode("4321").size());
		
		
	}
	
	@Test
	void testFindAll() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		List<Ticket> list = new ArrayList<>();
		list.add(new Ticket(1L, "Something", LocalDate.now(), "Informed to the engineer", "open"));
		list.add(new Ticket(2L, "Something", LocalDate.now(), "Informed to the tech support", "close"));
		list.add(new Ticket(3L, "Something else", LocalDate.now(), "Informed to the engineer", "open"));
		list.add(new Ticket(4L, "Something new", LocalDate.now(), "Reported to the manager", "open"));
		list.add(new Ticket(5L, "Working fine", LocalDate.now(), "Ticket closed", "close"));
		

		Pageable pageable1 = PageRequest.of(0, 100);

		Pageable pageable2 = PageRequest.of(0, 3);
		
		Mockito.when(ticketServiceMock.findAll(pageable1))
		   .thenReturn(list);
		
		Mockito.when(ticketServiceMock.findAll(pageable2))
		   .thenReturn(list);
		
		assertEquals(5, ticketServiceMock.findAll(pageable1).size());
		assertEquals(5, ticketServiceMock.findAll(pageable2).size());
			
		
	}
	
	@Test
	void testGetOne() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		Ticket ticket = new Ticket(1L, "Something", LocalDate.now(), "Informed to the engineer", "open");
		
		
		
		Mockito.when(ticketServiceMock.getOne(1L))
			   .thenReturn(ticket);
		
		assertEquals("Something", ticketServiceMock.getOne(1L).getDescription());
		
	}
	
	@Test
	void testSave() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		Ticket ticket = new Ticket(1L, "Something", LocalDate.now(), "Informed to the engineer", "open");
			
		
		Mockito.when(ticketServiceMock.save(ticket))
			   .thenReturn(ticket);
		
		assertEquals("Something", ticketServiceMock.save(ticket).getDescription());
	}
	
	@Test
	void testDeleteById() {
		TicketService ticketServiceMock = Mockito.mock(TicketService.class);
		
		Mockito.doNothing().when(ticketServiceMock).deleteById(1L);
		 
	}
	
	
//	CustomerService testing
	
	@Test
	void testCustomerGetOne() {
		CustomerService customerService = Mockito.mock(CustomerService.class);
		
		Customer customer = new Customer(1L, "Harry", "harry@gmail.com", "1234", "9876543211");
		
		Mockito.when(customerService.getOne(1L))
			   .thenReturn(customer);
		
		assertEquals("Harry", customerService.getOne(1L).getName());
	}
	
	
	@Test
	void testCustomerFindAll() {
		CustomerService customerServiceMock = Mockito.mock(CustomerService.class);
		
		List<Customer> list = new ArrayList<>();
		list.add(new Customer(1L, "Harry", "harry@gmail.com", "1234", "9876543211"));
		list.add(new Customer(1L, "Ron", "ron@gmail.com", "4321", "8765432191"));
		list.add(new Customer(1L, "Hermione", "hermione@gmail.com", "9876", "7654321981"));
		list.add(new Customer(1L, "Wilson", "wilson@gmail.com", "6789", "6543219871"));
		

		Pageable pageable1 = PageRequest.of(0, 100);

		Pageable pageable2 = PageRequest.of(0, 3);
		
		Mockito.when(customerServiceMock.findAll(pageable1))
		   .thenReturn(list);
		
		Mockito.when(customerServiceMock.findAll(pageable2))
		   .thenReturn(list);
		
		assertEquals(4, customerServiceMock.findAll(pageable1).size());
		assertEquals(4, customerServiceMock.findAll(pageable2).size());			
		
	}
	
	@Test
	void testCustomerSave() {
		CustomerService customerServiceMock = Mockito.mock(CustomerService.class);
		
		Customer customer = new Customer(1L, "Harry", "harry@gmail.com", "1234", "9876543211");
		
		Mockito.when(customerServiceMock.save(customer))
		   .thenReturn(customer);
	
		assertEquals("Harry", customerServiceMock.save(customer).getName());
		
		
	}
	
	@Test
	void testCustomerDeleteById() {
		CustomerService customerServiceMock = Mockito.mock(CustomerService.class);

		Mockito.doNothing().when(customerServiceMock).deleteById(1L);

	}
	
	
	
//	ExecutiveService Testing
	@Test
	void testExecutiveGetOne() {
		ExecutiveService executiveService = Mockito.mock(ExecutiveService.class);
		
		Executive executive = new Executive(1L, "John", "Tech Support");
		
		Mockito.when(executiveService.getOne(1L))
			   .thenReturn(executive);
		
		assertEquals("John", executiveService.getOne(1L).getName());
	}
	
	@Test
	void testExecutiveSave() {
		ExecutiveService executiveService = Mockito.mock(ExecutiveService.class);
		
		Executive executive = new Executive(1L, "John", "Tech Support");
		
		Mockito.when(executiveService.save(executive))
			   .thenReturn(executive);
		
		assertEquals("John", executiveService.save(executive).getName());
	}
	
	@Test
	void testExecutiveFindAll() {
		ExecutiveService executiveServiceMock = Mockito.mock(ExecutiveService.class);
		
		List<Executive> list = new ArrayList<>();
		list.add(new Executive(1L, "John", "Tech Support"));
		list.add(new Executive(2L, "Jack", "IT"));

		

		Pageable pageable1 = PageRequest.of(0, 100);

		Pageable pageable2 = PageRequest.of(0, 3);
		
		Mockito.when(executiveServiceMock.findAll(pageable1))
		   .thenReturn(list);
		
		Mockito.when(executiveServiceMock.findAll(pageable2))
		   .thenReturn(list);
		
		assertEquals(2, executiveServiceMock.findAll(pageable1).size());
		assertEquals(2, executiveServiceMock.findAll(pageable2).size());			
		
	}
	
	
	@Test
	void testExecutiveDeleteById() {
		ExecutiveService executiveServiceMock = Mockito.mock(ExecutiveService.class);

		Mockito.doNothing().when(executiveServiceMock).deleteById(1L);

	}
	
	
	
}
