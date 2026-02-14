package com.cinco;

import java.util.UUID;

/**
 * Represents a license. This takes all definitions
 * from the Item class.
 */

public class License extends Item {

	private double annualFee;
	private double serviceFee;
	
	public License(UUID uuid, String name,
				   double serviceFee, double annualFee) {
		super(uuid, name);
		this.serviceFee = serviceFee;
		this.annualFee = annualFee;
	}

	public double getServiceFee() {
		return serviceFee;
	}
	
	public double getAnnualFee() {
		return annualFee;
	}
}
