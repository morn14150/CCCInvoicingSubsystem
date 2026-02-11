package com.cinco;

/**
 * Represents the common definition of all items
 * (Equipment, license, service)
 * 
 * This class cannot be used individually without
 * using one of the three class above.
 */

public abstract class Item {
	private String uuid;
	private String name;

	public Item(String uuid, String name) {
		this.uuid = uuid;
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

}
