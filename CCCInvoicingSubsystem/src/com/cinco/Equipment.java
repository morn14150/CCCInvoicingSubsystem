package com.cinco;

import java.util.UUID;

/**
 * Represents an equipment. This takes all definitions
 * from the Item class.
 */

public class Equipment extends Item {

	private double costPerItem;
	
	public Equipment(UUID uuid, String name, 
			 		 double costPerItem) {
		super(uuid, name);
		this.costPerItem = costPerItem;
	}

	public double getCostPerItem() {
		return costPerItem;
	}
}
