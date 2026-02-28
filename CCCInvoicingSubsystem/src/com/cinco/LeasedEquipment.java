package com.cinco;

/**
 * Equipment, but with the Lease option
 */

public class LeasedEquipment implements InvoiceItem {
    private Equipment equipment;
    private int quantity;

    public LeasedEquipment(Equipment equipment, int quantity) {
        this.equipment = equipment;
        this.quantity = quantity;
    }

    @Override
    public double getSubtotal() {
        double totalLease = equipment.getCostPerItem() * quantity * 1.5;
        return totalLease / 36.0;
    }

    @Override
    public double getTaxes() {
        double totalLease = equipment.getCostPerItem() * quantity * 1.5;
        
        if (totalLease < 2000.0) {
            return 0.0;
        } else if (totalLease < 7000.0) {
            return 175.0;
        } else {
            return 350.0;
        }
    }

    @Override
    public double getTotal() {
        return getSubtotal() + getTaxes();
    }

    @Override
    public String toString() {
        return String.format("Lease: %s (%d units)", equipment.getName(), quantity);
    }
}