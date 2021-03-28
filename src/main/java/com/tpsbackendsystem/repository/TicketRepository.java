package com.tpsbackendsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tpsbackendsystem.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	@Query("select t from Ticket t join t.customer c where c.id=?1")
	List<Ticket> fetchTicketByCustomerID(Long custID);

 
}
