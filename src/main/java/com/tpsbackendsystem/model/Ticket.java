package com.tpsbackendsystem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ticket { // spring will create table 'ticket' in DB

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // primary key in DB
	private String description;
	private LocalDate createdDate;
	private String actionTaken;
	private String status; //open/close
	
//	Which executive is creating this ticket
	
//	Which customer is this ticket for
	
	@OneToOne
	private Executive executive; // This is the relationship between Executive and Ticket models. It is one to one
	
	@OneToOne
	private Customer customer; // This is the relationship between Customer and Ticket models. It is one to one
	
	
	

	public Ticket() {
		super();
	}

	public Ticket(Long id, String description, LocalDate createdDate, String actionTaken, String status) {
		super();
		this.id = id;
		this.description = description;
		this.createdDate = createdDate;
		this.actionTaken = actionTaken;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Executive getExecutive() {
		return executive;
	}

	public void setExecutive(Executive executive) {
		this.executive = executive;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
