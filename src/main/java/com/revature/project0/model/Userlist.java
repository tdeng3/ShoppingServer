package com.revature.project0.model;

public class Userlist {
	private int id;
	private String email;
	private String password;
	private String role;
	public Userlist() {
		super();
	}
	public Userlist(String role) {
		this.role = role;
	}
	public Userlist (String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public Userlist (int id, String email, String password, String role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String Password) {
		this.password = Password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String Role) {
		this.role = Role;
	}
	
	@Override
	public String toString() {
		return "Userlist [id=" + id + ", email=" + email + ", Password=" + password + ", Role=" + role + "]";
	}
	
}
