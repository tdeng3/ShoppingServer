package com.revature.project0.model;

public class ProductList {
	private int id;
	private String productName;
	private String productDescription;
	private String prductPrice;
	
	public ProductList() {
		super();
	}
	public ProductList(String productName, String productDescription, String productPrice) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.prductPrice = productName;
	}
	
	public ProductList(int id, String productName, String productDescription, String productPrice) {
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.prductPrice = productPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getPrductPrice() {
		return prductPrice;
	}
	public void setPrductPrice(String prductPrice) {
		this.prductPrice = prductPrice;
	}
	@Override
	public String toString() {
		return "ProductList [id=" + id + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", prductPrice=" + prductPrice + "]";
	}
	
	

}
