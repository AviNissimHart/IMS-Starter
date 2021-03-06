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
	
	public Order(Long id, Long itemId) {
		this.setId(id);
		this.setItemId(itemId);
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + Float.floatToIntBits(orderTotal);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (Float.floatToIntBits(orderTotal) != Float.floatToIntBits(other.orderTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [order id=" + id + ", customerId=" + customerId + " total= �" + orderTotal + "]" +  "\n  Items [item id=" + itemId + "]";
	}
	



}
