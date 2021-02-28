package com.tpsbackendsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket { // spring will create table 'ticket' in DB

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // primary key in DB
	private String description;
	private String issuer;
	//ctrl + shift + F : for formating the code.
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

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

}
