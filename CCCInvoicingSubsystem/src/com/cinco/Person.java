package com.cinco;

import java.util.List;
import java.util.UUID;

/**
 * Represents a person.
 */

public class Person {

	private UUID uuid;
	private String firstName;
	private String lastName;
	private String phone;
	private List<String> email;
	
	public Person(UUID uuid, String firstName, String lastName, 
				  String phone, List<String> email) {
		
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public List<String> getEmail() {
		return email;
	}
	
}
