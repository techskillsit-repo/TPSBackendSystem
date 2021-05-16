package com.tpsbackendsystem.TicketDto;

import java.time.LocalDate;

public class TicketDto {
	private Long id; // primary key in DB
	private String description;
	private LocalDate createdDate;
	private String actionTaken;
	private String status;
	private String CustomerName;
	private String CustomerEmail;
	private String ExecutiveName;
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
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerEmail() {
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}
	public String getExecutiveName() {
		return ExecutiveName;
	}
	public void setExecutiveName(String executiveName) {
		ExecutiveName = executiveName;
	}

}
