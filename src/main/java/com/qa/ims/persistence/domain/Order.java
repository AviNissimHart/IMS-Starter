package com.qa.ims.persistence.domain;

public class Order {

	private Long id;
	private Long customerId;
	//private Long itemId;
	
	public Order(Long customerId) {
		this.setCustomerId(customerId);
	}
	
	public Order(Long id, Long customerId) {
		this.setId(id);
		this.setCustomerId(customerId);
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

	

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + "]";
	}
	



}
