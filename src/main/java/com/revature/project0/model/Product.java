package com.revature.project0.model;

public class Product {
	private int id;
	private String name;
	private String orderDate;
	private int price;
	private OrderStatus status;
	
	
	public Product() {
		super();
	}
	public Product(String name, String orderDate, int price,  OrderStatus status) {
		this.name = name;
		this.orderDate = orderDate;
		this.price = price;
		this.status = status;
		
	}
	public Product(int id, String name, String orderDate, int price, OrderStatus status) {
		this.id = id;
		this.name = name;
		this.orderDate = orderDate;
		this.price = price;
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public OrderStatus getstatus() {
		return status;
	}
	public void setOrderStatus(OrderStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", orderDate=" + orderDate + ", price=" + price + ", status="
				+ status + "]";
	}
	
}
