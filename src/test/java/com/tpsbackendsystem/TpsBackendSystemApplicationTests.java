package com.tpsbackendsystem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	void testSum() {
		assertEquals(7, ticketService.sum(4, 3));
		assertNotEquals(8, ticketService.sum(4, 3));
	}
}
