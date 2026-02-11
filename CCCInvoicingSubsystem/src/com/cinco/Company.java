package com.cinco;

/**
 * Represents a company.
 */

public class Company {

	private String companyUuid;
	private String contactUuid;
	private String name;
	private Address address;
	
	public Company(String companyUuid, String contactUuid, 
				   String name, Address address) {
		super();
		this.companyUuid = companyUuid;
		this.contactUuid = contactUuid;
		this.name = name;
		this.address = address;
	}

	public String getCompanyUuid() {
		return companyUuid;
	}

	public String getContactUuid() {
		return contactUuid;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}
	
}
