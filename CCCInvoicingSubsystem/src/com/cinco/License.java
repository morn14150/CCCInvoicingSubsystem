package com.cinco;

/**
 * Represents a license. This takes all definitions
 * from the Item class.
 */

public class License extends Item {

	private double annualFee;
	private double serviceFee;
	
	public License(String uuid, String name,
				   double annualFee, double serviceFee) {
		super(uuid, name);
		this.annualFee = annualFee;
		this.serviceFee = serviceFee;
	}

	public double getAnnualFee() {
		return annualFee;
	}

	public double getServiceFee() {
		return serviceFee;
	}
}
