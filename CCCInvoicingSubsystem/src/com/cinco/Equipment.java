package com.cinco;

/**
 * Represents an equipment. This takes all definitions
 * from the Item class.
 */

public class Equipment extends Item {

	private double costPerItem;
	
	public Equipment(String uuid, String name, 
			 		 double costPerItem) {
		super(uuid, name);
		this.costPerItem = costPerItem;
	}

	public double getCostPerItem() {
		return costPerItem;
	}
}
