package com.revature.project0.template;

public class InsertProductTemplate {
	private String name;
	private String status;
	
	public InsertProductTemplate() {
		super();
	}
	
	public InsertProductTemplate(String name, String status) {
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "InsertProductTemplate [name=" + name + ", status=" + status + "]";
	}
	
	
}
