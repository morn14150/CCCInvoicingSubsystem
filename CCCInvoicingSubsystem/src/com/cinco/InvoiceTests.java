package com.cinco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * JUnit test suite for the invoice system.
 */
public class InvoiceTests {

	public static final double TOLERANCE = 0.1;


	/**
	 * Tests the subtotal, tax total and grand total values of an invoice in
	 * the system.
	 */
	@Test
	public void testInvoice01() {

		//1. Create test instances 3 different types of invoice items
		//   You may reuse the instances from your Entity test suites
		//2. Create an instance of your invoice and add these 3 items to it
		//3. Calculate and compare the values to the expected values.
		//data values
		
		Person salesperson = new Person(UUID.randomUUID(), "Jim", "Halpert", "555-0101", null);
		Company customer   = new Company(UUID.randomUUID(), salesperson, "Dunder Mifflin", null);
		Invoice invoice    = new Invoice(UUID.randomUUID(), "2026-02-27", customer, salesperson);
		
		// 500 PURCHASED MONITORS
		Equipment monitor = new Equipment(UUID.randomUUID(), "Monitor", 199.99);
		invoice.addItem(new PurchasedEquipment(monitor, 500));
		
		// MICROSOFT ACTIVATION SCRIPTS at $6.9/hr for 1 hour + $42.0 fee
		Service mas = new Service(UUID.randomUUID(), "MAS", 6.9);
		invoice.addItem(new BilledService(mas, 1));
		
		// LibreOffice PRO PLUS MAX ULTRA with $25.99 fee and $1212.12 annual fee for 420 days
		License libreOffice = new License(UUID.randomUUID(), "LibreOffice", 25.99, 1212.12);
		invoice.addItem(new BilledLicense(libreOffice, 420));
		
		double expectedSubtotal   = 99995.00 + 131.90 + 1420.75;
		double expectedTaxTotal   = 5249.74 + 4.15 + 0.00;
		double expectedGrandTotal = expectedSubtotal + expectedTaxTotal;

		double actualSubtotal   = invoice.calculateSubtotal();
		double actualTaxTotal   = invoice.calculateTaxes();
		double actualGrandTotal = invoice.calculateTotal();

		//Use assertEquals with the TOLERANCE to compare:
		assertEquals(expectedSubtotal, actualSubtotal, TOLERANCE);
		assertEquals(expectedTaxTotal, actualTaxTotal, TOLERANCE);
		assertEquals(expectedGrandTotal, actualGrandTotal, TOLERANCE);
	}

	/**
	 * Tests the subtotal, tax total and grand total values of an invoice in
	 * the VGB system.
	 */
	@Test
	public void testInvoice02() {
		//1. Create test instances the other 2 types of invoice items
		//   You may reuse the instances from your Entity test suites
		Person salesperson = new Person(UUID.randomUUID(), "Dwight", "Schrute", "555-0102", null);
		Company customer = new Company(UUID.randomUUID(), salesperson, "Schrute Farms", null);
		Invoice invoice = new Invoice(UUID.randomUUID(), "2026-02-28", customer, salesperson);

		// 500 LEASED MONITORS
		Equipment monitor = new Equipment(UUID.randomUUID(), "Monitor", 199.99);
		invoice.addItem(new LeasedEquipment(monitor, 500));

		// MICROSOFT ACTIVATION SCRIPTS at $6.9/hr for 1 hour + $42.0 fee
		Service mas = new Service(UUID.randomUUID(), "MAS", 6.9);
		invoice.addItem(new BilledService(mas, 1));

		//2. Create an instance of your invoice and add these 2 items to it
		double expectedSubtotal = 4166.46 + 131.90;
		double expectedTaxTotal = 350.00 + 4.15;
		double expectedGrandTotal = expectedSubtotal + expectedTaxTotal;

		//3. Calculate and compare the values to the expected values.
		assertEquals(expectedSubtotal, invoice.calculateSubtotal(), TOLERANCE);
		assertEquals(expectedTaxTotal, invoice.calculateTaxes(), TOLERANCE);
		assertEquals(expectedGrandTotal, invoice.calculateTotal(), TOLERANCE);
	}



}
