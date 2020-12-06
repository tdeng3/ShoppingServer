package com.revature.project0.template;

public class InsertProductTemplate {
	private String name;
	private String orderDate;
	private int price;
	private String status;
	
	public InsertProductTemplate() {
		super();
	}
	
	public InsertProductTemplate(String name, String orderDate, int price, String status) {
		this.name = name;
		this.orderDate = orderDate;
		this.price = price;
		this.status = status;
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "InsertProductTemplate [name=" + name + ", orderDate=" + orderDate + ", price=" + price + ", status="
				+ status + "]";
	}

	
	
	
}
