package com.cinco;

import java.util.UUID;

/**
 * Represents a service. This takes all definitions
 * from the Item class.
 */

public class Service extends Item {
	private double costPerHour;
	
	public Service(UUID uuid, String name,
				   double costPerHour) {
		super(uuid, name);
		this.costPerHour = costPerHour;
	}

	public double getCostPerHour() {
		return costPerHour;
	}
}
