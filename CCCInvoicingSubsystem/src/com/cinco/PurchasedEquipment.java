package com.cinco;

/**
 * Equipment, but with the Purchase option
 */

public class PurchasedEquipment implements InvoiceItem {
    private Equipment equipment;
    private int quantity;

    public PurchasedEquipment(Equipment equipment, int quantity) {
        this.equipment = equipment;
        this.quantity = quantity;
    }

    @Override
    public double getSubtotal() {
        return equipment.getCostPerItem() * quantity;
    }

    @Override
    public double getTaxes() {
        return getSubtotal() * 0.0525;
    }

    @Override
    public double getTotal() {
        return getSubtotal() + getTaxes();
    }

    @Override
    public String toString() {
        return String.format("Purchase: %s (%d units)", equipment.getName(), quantity);
    }
}