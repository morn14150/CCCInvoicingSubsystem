package com.cinco;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class connects persons, companies and billed items together to build
 * a comprehensive invoicing system.
 */

public class Invoice {
    private UUID invoiceUuid;
    private String date;
    private Company customer;
    private Person salesperson;
    private List<InvoiceItem> items;

    public Invoice(UUID invoiceUuid, String date, Company customer, Person salesperson) {
        this.invoiceUuid = invoiceUuid;
        this.date = date;
        this.customer = customer;
        this.salesperson = salesperson;
        this.items = new ArrayList<>();
    }

    public void addItem(InvoiceItem item) {
        this.items.add(item);
    }

    // Iterate through all items and sum their subtotals
    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (InvoiceItem item : items) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    // Iterate through all items and sum their taxes
    public double calculateTaxes() {
        double taxes = 0.0;
        for (InvoiceItem item : items) {
            taxes += item.getTaxes();
        }
        return taxes;
    }

    // Iterate through all item subtotals and taxes to calculate the (final) total
    public double calculateTotal() {
        double total = 0.0;
        for (InvoiceItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public UUID getInvoiceUuid() {
        return invoiceUuid;
    }

    public String getDate() {
        return date;
    }

    public Company getCustomer() {
        return customer;
    }

    public Person getSalesperson() {
        return salesperson;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }
}