package com.iii.amirutham.model.order;
public enum PaymentType {
	
	
	
	CARD("Credit/Debit Card"), COD("cash On Delivary"), UPI("UPI-Wallet"), BANK("Bank"),UNPAIED("Pending");

private String value;
	
	private PaymentType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}