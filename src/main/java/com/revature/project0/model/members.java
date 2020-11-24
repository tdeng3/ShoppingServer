package com.revature.project0.model;

public class members {
	 private int id;
	 private String names;
//	 private String passwords;
	 private String roles;
	 public members() {
		 super();
	 }
	 
	 public members (int id, String email, String roles) {
		 this.id = id;
		 this.names = email;
//		 this.passwords = password;
		 this.roles = roles;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String email) {
		this.names = email;
	}

//	public String getPasswords() {
//		return passwords;
//	}
//
//	public void setPasswords(String password) {
//		this.passwords = password;
//	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "members [id=" + id + ", names=" + names + ", roles=" + roles + "]";
	}
	 
}
