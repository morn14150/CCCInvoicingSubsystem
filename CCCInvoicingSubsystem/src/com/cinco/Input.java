package com.cinco;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Input class. Contains 3 functions to read
 * in 3 .csv files located in the /data folder.
 */

public class Input {
	public static List<Person> readPerson() {
		List<Person> persons = new ArrayList<>();
		File f = new File("data/Persons.csv");
		
		try {
			Scanner s = new Scanner(f);
			String line = null;
			line = s.nextLine();
			
			while(s.hasNextLine()) {
				line = s.nextLine();
				if(line.trim().isEmpty()) continue;
				String tokens[]  = line.split(",");
				if(tokens.length < 3) continue;
				
				UUID uuid        = UUID.fromString(tokens[0]);
				String firstName = tokens[1];
				String lastName  = tokens[2];
				
				String phone = "";
				List<String> email = new ArrayList<>();
				if (tokens.length > 3) {
					phone        = tokens[3];
					for (int i = 4; i<tokens.length; i++) {
						if(!tokens[i].trim().isEmpty()) {
							email.add(tokens[i]);
						}
					}
				}
				
				Person p = new Person(uuid, firstName, lastName,
									  phone, email);
				persons.add(p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.err.println("Persons.csv not found.");
		}
		return persons;
	}
	
	public static List<Company> readCompany(List<Person> persons){
		List<Company> companies = new ArrayList<>();
		File f = new File("data/Companies.csv");
		
		try {
			Scanner s = new Scanner(f);
			String line = null;
			line = s.nextLine();
			
			while(s.hasNextLine()) {
				line = s.nextLine();
				if(line.trim().isEmpty()) continue;
				String tokens[] = line.split(",");
				
				UUID companyUuid = UUID.fromString(tokens[0]);
				UUID contactUuid = UUID.fromString(tokens[1]);
				String name      = tokens[2];					
				String street    = tokens[3];
				String city      = tokens[4];
				String state     = tokens[5];
				String zip       = tokens[6];
				
				Person primaryContact = null;
			    for (Person p : persons) {
			        if (p.getUuid().equals(contactUuid)) {
			            primaryContact = p;
			            break; 
			        }
			    }
				Address address = new Address(street, city,
											  state, zip);
				Company c = new Company(companyUuid, primaryContact, 
										name, address);
				companies.add(c);
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.err.println("Companies.csv not found.");
		}
		return companies;
	}
	
	public static List<Item> readItem(){
		List<Item> items = new ArrayList<>();
		File f = new File("data/Items.csv");
		
		try {
			Scanner s = new Scanner(f);
			String line = null;
			line = s.nextLine();
			
			while(s.hasNextLine()) {
				line = s.nextLine();
				if(line.trim().isEmpty()) continue;
				String tokens[] = line.split(",");
				
				UUID uuid  = UUID.fromString(tokens[0]);
				String type  = tokens[1];
				String name  = tokens[2];
				
				if (type.equals("E")) {
					double cost = Double.parseDouble(tokens[3]);
					Equipment e = new Equipment(uuid, name, cost);
					items.add(e);

				} else if (type.equals("S")) {
					double cost = Double.parseDouble(tokens[3]);
					Service service = new Service(uuid, name, cost);
					items.add(service);

				} else if (type.equals("L")) {
					double serviceFee = Double.parseDouble(tokens[3]);
					double annualFee = Double.parseDouble(tokens[4]);
					License l = new License(uuid, name, 
											serviceFee, 
											annualFee);
					items.add(l);
				}
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.err.println("Items.csv not found");
		}
		return items;
	}
}
