package com.vaadin.tutorial.com.backend.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Contact extends AbstractEntity {


	public enum Status {
		ImportedLead, NotContacted, Contacted, Customer, ColsedLost
	}

	@NotNull
	@NotEmpty
	private String firstName = "";

	@NotNull
	@NotEmpty
	private String lastName = "";

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Contact.Status status;

	@Email
	@NotNull
	@NotEmpty
	private String email;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
