package com.cinco;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * JUnit test suite for the invoice system.
 */
public class EntityTests {

	public static final double TOLERANCE = 0.1;

	/**
	 * Creates an instance of purchased equipment and tests if its cost and tax
	 * calculations are correct.
	 */
	@Test
	public void testEquipmentPurchase() {
		// 500 PURCHASED MONITORS for 199.99
		UUID uuid = UUID.fromString("dca4b8e6-9c13-4b1d-aeef-1e3f237f9a9a");
		String name = "Monitor";
		double pricePerUnit = 199.99;

		double expectedCost = 99995.00;
		double expectedTax = 5249.74;
		double expectedTotal = 105244.74;
		
		Equipment monitor = new Equipment(uuid, name, pricePerUnit);
        PurchasedEquipment purchase = new PurchasedEquipment(monitor, 500);

		assertEquals(expectedCost, purchase.getSubtotal(), TOLERANCE);
		assertEquals(expectedTax, purchase.getTaxes(), TOLERANCE);
		assertEquals(expectedTotal, purchase.getTotal(), TOLERANCE);
		
		String s = purchase.toString();
		assertTrue(s.contains("Purchase"));
		assertTrue(s.contains("Monitor"));

	}

	@Test
	public void testEquipmentLease() {
		// 500 LEASED MONITORS for 199.99 (definitely not a bad deal lol)
        Equipment monitor = new Equipment(UUID.randomUUID(), "Monitor", 199.99);
        LeasedEquipment lease = new LeasedEquipment(monitor, 500);

        // order for assertEquals: expected, actual, tolerance
        assertEquals(4166.46, lease.getSubtotal(), TOLERANCE); 
        assertEquals(350.00, lease.getTaxes(), TOLERANCE); 
        assertEquals(4516.46, lease.getTotal(), TOLERANCE);
        
        String s = lease.toString();
        assertTrue(s.contains("Lease"));
		assertTrue(s.contains("Monitor"));
	}

	@Test
	public void testService() {
		// MICROSOFT ACTIVATION SCRIPTS at $6.9/hr for 1 hour + $42.0 fee
        Service mas = new Service(UUID.randomUUID(), "MAS", 6.9);
        BilledService service = new BilledService(mas, 1);

        assertEquals(131.90, service.getSubtotal(), TOLERANCE);
        assertEquals(4.15, service.getTaxes(), TOLERANCE); 
        assertEquals(136.05, service.getTotal(), TOLERANCE);
        
        String s = service.toString();
		assertTrue(s.contains("MAS"));
	}

	@Test
	public void testLicense() {
		// LibreOffice PRO PLUS MAX ULTRA with $25.99 fee and $1212.12 annual fee for 420 days
        License libreOffice = new License(UUID.randomUUID(), "LibreOffice PRO PLUS MAX ULTRA", 25.99, 1212.12);
        BilledLicense license = new BilledLicense(libreOffice, 420);

        assertEquals(1420.75, license.getSubtotal(), TOLERANCE);
        assertEquals(0.00, license.getTaxes(), TOLERANCE);
        assertEquals(1420.75, license.getTotal(), TOLERANCE);
        
        String s = license.toString();
		assertTrue(s.contains("LibreOffice PRO PLUS MAX ULTRA"));
	}

}
