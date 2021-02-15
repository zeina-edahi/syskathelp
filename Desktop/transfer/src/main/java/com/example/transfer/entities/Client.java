package com.example.transfer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
private long id;
	@Column(name="username",length=35)
private String username;
	@Column(name="password",length=8)
private String password;
private String nom;
private String prenom;
private String email;
private int permission=0;

public Client() {
	super();
	// TODO Auto-generated constructor stub
}
public Client(long id, String username, String password, String nom, String prenom, String email, int permission) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.permission = permission;
}


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPermission() {
	return permission;
}
public void setPermission(int permission) {
	this.permission = permission;
}




}
