package com.cinco;

import java.util.UUID;

/**
 * Represents a company.
 */

public class Company {

	private UUID companyUuid;
	private UUID personUuid;
	private String name;
	private Address address;
	
	public Company(UUID companyUuid, UUID personUuid, 
				   String name, Address address) {
		super();
		this.companyUuid = companyUuid;
		this.personUuid = personUuid;
		this.name = name;
		this.address = address;
	}

	public UUID getCompanyUuid() {
		return companyUuid;
	}

	public UUID getContactUuid() {
		return personUuid;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}
	
}
