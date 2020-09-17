package com.qa.ims.persistence.domain;

public class Order {

	private Long id;
	private Long customerId;
	private Long itemId;
	private float orderTotal;
	
	public Order(Long customerId) {
		this.setCustomerId(customerId);
	}
	
	public Order(Long id, Long customerId, float orderTotal) {
		this.setId(id);
		this.setCustomerId(customerId);
		this.setOrderTotal(orderTotal);
	}
	
//	public Order(Long id, Long itemId) {
//		this.setId(id);
//		this.setItemId(itemId);
//	}

	public Order(Long id, Long customerId, float orderTotal, Long itemId) {
		this.setId(id);
		this.setCustomerId(customerId);
		this.setOrderTotal(orderTotal);
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

	public float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Override
	public String toString() {
		return "Order [order id=" + id + ", customerId=" + customerId + " total= £" + orderTotal + "]" +  "\n  Items [item id=" + itemId + "]";
	}
	



}
