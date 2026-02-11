package com.cinco;

import java.util.List;

/**
 * Minh Tran - mtran33@huskers.unl.edu
 * Last updated: 2026-02-10
 * 
 * CCC management database main file. This program 
 * is designed to keep track of client invoices.
 * 
 * More information can be found in DesignDocument.pdf
 * in the /doc folder.
 */

public class DataConverter {
	public static void main(String[] args) {
		System.out.println("Starting program...");
		
		List<Person> persons = Input.readPerson();
		System.out.println("Persons loaded: " + persons.size());

		List<Company> companies = Input.readCompany();
		System.out.println("Companies loaded: " + companies.size());
		
		List<Item> items = Input.readItem();
		System.out.println("Items loaded: " + items.size());
		
		System.out.println("End of program.");
	}
}
