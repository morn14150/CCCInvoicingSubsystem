package com.cinco;

import java.util.UUID;

/**
 * Represents a company.
 */

public class Company {

	private UUID companyUuid;
	private Person primaryContact;
	private String name;
	private Address address;
	
	public Company(UUID companyUuid, Person primaryContact, 
				   String name, Address address) {
		super();
		this.companyUuid = companyUuid;
		this.primaryContact = primaryContact;
		this.name = name;
		this.address = address;
	}

	public UUID getCompanyUuid() {
		return companyUuid;
	}

	public Person getPrimaryContact() {
		return primaryContact;
	}
	
	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}
	
}
