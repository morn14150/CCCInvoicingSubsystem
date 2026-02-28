package com.cinco;

/**
 * Service, but with added calculation methods to support the invoicing process
 */

public class BilledService implements InvoiceItem {
    private Service service;
    private double hours;

    public BilledService(Service service, double hours) {
        this.service = service;
        this.hours = hours;
    }

    @Override
    public double getSubtotal() {
        return (hours * service.getCostPerHour()) + 125.0; 
    }

    @Override
    public double getTaxes() {
        return getSubtotal() * 0.0315;
    }

    @Override
    public double getTotal() {
        return getSubtotal() + getTaxes();
    }

    @Override
    public String toString() {
        return String.format("Service: %s (%.2f hours)", service.getName(), hours);
    }
}