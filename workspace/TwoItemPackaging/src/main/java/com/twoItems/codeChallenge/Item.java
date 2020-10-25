package com.twoItems.codeChallenge;

public class Item {

	private double price;
	private String itemName;
	
	public Item(String itemName, double price) {
		this.price = price;
		this.itemName = itemName;
	}
	
	public Item() {
		
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return itemName + ", " + price;
	}
}
