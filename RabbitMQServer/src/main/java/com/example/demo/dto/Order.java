package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Order {

	private String orderId;
	private String name;
	private String quantity;
	private String price;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Order(String orderId, String name, String quantity, String price) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public Order() {
		super();
	}
	
	
	
}
