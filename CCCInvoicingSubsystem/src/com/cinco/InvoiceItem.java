package com.cinco;

/**
 * Item interface to help with the invoicing process
 */

public interface InvoiceItem {
    double getSubtotal();
    double getTaxes();
    double getTotal();
}