package com.cinco;

import java.util.List;

/**
 * Represents a person.
 */

public class Person {

	private String personUUID;
	private String firstName;
	private String lastName;
	private String phone;
	private List<String> email;
	
	public Person(String personUUID, String firstName, 
				  String lastName, String phone, 
				  List<String> email) {
		
		this.personUUID = personUUID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}

	public String getPersonUUID() {
		return personUUID;
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
