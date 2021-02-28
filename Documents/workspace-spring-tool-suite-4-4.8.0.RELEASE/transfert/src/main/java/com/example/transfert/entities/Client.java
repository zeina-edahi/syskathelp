package com.example.transfert.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id 
	@GeneratedValue()
	 
public long id;
private String nom;
private String prenom;
private String email;
@Column(name="telephone",length=20)
private String telephone;

@OneToMany(mappedBy ="client")
private List<Compte> comptes;

public List<Compte> getComptes() {
	return comptes;
}
public void setComptes( List<Compte> comptes) {
	this.comptes = comptes;
}


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Client() {
	super();
	// TODO Auto-generated constructor stub
}

public Client(String nom, String prenom, String email, String telephone) {
	super();
	
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.telephone = telephone;
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
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}



}

