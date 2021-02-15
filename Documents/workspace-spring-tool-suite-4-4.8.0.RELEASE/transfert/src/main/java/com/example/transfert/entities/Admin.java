package com.example.transfert.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue
	private long id;
	@Column(length=35)
	private String username;
	@Column(length=8)
	private String password;
	private int permission=1;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(long id, String username, String password, int permission) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.permission = permission;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
}