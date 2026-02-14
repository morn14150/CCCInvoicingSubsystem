package com.cinco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

/**
 * Output file. Handles exporting data to JSON and XML formats.
 */
public class Output {
	
	public static void personsToXml(List<Person> persons) {
		XStream xstream = new XStream();
		
		xstream.allowTypesByWildcard(new String[] { "com.cinco.**" });
		
		xstream.alias("person", Person.class);
		
		String xml = xstream.toXML(persons);
		saveToFile("data/Persons.xml", xml);
	}

	public static void companiesToXml(List<Company> companies) {
		XStream xstream = new XStream();
		xstream.allowTypesByWildcard(new String[] { "com.cinco.**" });
		
		xstream.alias("company", Company.class);
		xstream.alias("address", Address.class);
		
		String xml = xstream.toXML(companies);
		saveToFile("data/Companies.xml", xml);
	}

	public static void itemsToXml(List<Item> items) {
		XStream xstream = new XStream();
		xstream.allowTypesByWildcard(new String[] { "com.cinco.**" });

		xstream.alias("equipment", Equipment.class);
		xstream.alias("service", Service.class);
		xstream.alias("license", License.class);
		
		xstream.alias("item", Item.class);
		
		String xml = xstream.toXML(items);
		saveToFile("data/Items.xml", xml);
	}

	public static void personsToJson(List<Person> persons) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(persons);
		saveToFile("data/Persons.json", json);
	}

	public static void companiesToJson(List<Company> companies) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(companies);
		saveToFile("data/Companies.json", json);
	}

	public static void itemsToJson(List<Item> items) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(items);
		saveToFile("data/Items.json", json);
	}


	private static void saveToFile(String fileName, String content) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName));
			out.println(content);
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error: Could not write to " + fileName);
			e.printStackTrace();
		}
	}
}