package com.cinco;

import java.util.UUID;

/**
 * Represents the common definition of all items
 * (Equipment, license, service)
 * 
 * This class cannot be used individually without
 * using one of the three class above.
 */

public abstract class Item {
	private UUID uuid;
	private String name;

	public Item(UUID uuid, String name) {
		this.uuid = uuid;
		this.name = name;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

}
