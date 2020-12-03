package com.revature.project0.model;

public class Product {
	private int id;
	private String name;
	private OrderStatus status;
	
	public Product() {
		super();
	}
	public Product(String name, OrderStatus status) {
		this.name = name;
		this.status = status;
	}
	public Product(int id, String name, OrderStatus status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OrderStatus getstatus() {
		return status;
	}
	public void setOrderStatus(OrderStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Product ID: " + this.id + " Product name: " + this.name + " Status: " + this.status  + "";
	}
}
