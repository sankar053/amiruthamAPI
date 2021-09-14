package com.iii.amirutham.model.order;
public enum OrderStatus {
	
	ORDERED("ordered"),
	PROCESSED("processed"),
	DELIVERED("delivered"),
	REFUNDED("refunded"),
	CANCELED("canceled"),
	CONFIRMED("confirmed"),
	SHIPMENT("In-Shipment"),
	;
	
	private String value;
	
	private OrderStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}