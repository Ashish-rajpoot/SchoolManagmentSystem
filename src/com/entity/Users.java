package com.entity;


public class Users {
	private int user_id;
	private String name, email, password, role;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Users(int user_id, String name, String email, String password, String role) {
		
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public Users(String name, String email, String password, String role) {
	
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	
	public Users(int user_id, String name, String email) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
	}
	
	

	
	
	
	public Users(int user_id, String password) {
		super();
		this.user_id = user_id;
		this.password = password;
	}
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	
}
