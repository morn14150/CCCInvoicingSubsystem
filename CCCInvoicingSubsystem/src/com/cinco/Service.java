package com.cinco;

/**
 * Represents a service. This takes all definitions
 * from the Item class.
 */

public class Service extends Item {
	private double costPerHour;
	
	public Service(String uuid, String name,
				   double costPerHour) {
		super(uuid, name);
		this.costPerHour = costPerHour;
	}

	public double getCostPerHour() {
		return costPerHour;
	}
}
