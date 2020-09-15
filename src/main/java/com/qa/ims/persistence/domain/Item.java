package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private String itemName;
	private float price;
	
	public Item(String itemName, float price) {
		this.setItemName(itemName);
		this.setPrice(price);
		
	}
	
	public Item(Long id, String itemName, float price) {
		this.setId(id);
		this.setItemName(itemName);
		this.setPrice(price);

}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", price=" + price + "]";
	}
	
	

}