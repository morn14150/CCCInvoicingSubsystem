package com.cinco;

/**
 * License, but with added calculation methods to support the invoicing process
 */

public class BilledLicense implements InvoiceItem {
    private License license;
    private int days;

    public BilledLicense(License license, int days) {
        this.license = license;
        this.days = days;
    }

    @Override
    public double getSubtotal() {
        double subtotal = (((double) days / 365.0) * license.getAnnualFee()) + license.getServiceFee();
        return Math.round(subtotal * 100.0) / 100.0;
    }

    @Override
    public double getTaxes() {
        return 0.0; 
    }

    @Override
    public double getTotal() {
        return getSubtotal() + getTaxes();
    }

    @Override
    public String toString() {
        return String.format("License: %s (%d days)", license.getName(), days);
    }
}