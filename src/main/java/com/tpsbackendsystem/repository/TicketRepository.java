package com.tpsbackendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpsbackendsystem.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
 
}
