package com.qa.ims.persistence.domain;

public class Order {
	private Long id;
	private Long customerId;
	private Long itemId;
	
	public Order(Long customerId, Long itemId) {
		this.setCustomerId(customerId);
		this.setItemId(itemId);
	}
	
	public Order(Long id, Long customerId, Long itemId) {
		this.setId(id);
		this.setCustomerId(customerId);
		this.setItemId(itemId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	

}
