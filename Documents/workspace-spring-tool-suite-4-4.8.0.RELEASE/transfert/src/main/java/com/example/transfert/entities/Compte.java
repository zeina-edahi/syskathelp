package com.example.transfert.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compte {
	@Id
	@Column(length=100)
private String num;
private long montant;
@ManyToOne
@JoinColumn(name="idC")
private Client client;

public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Compte() {
	super();
	// TODO Auto-generated constructor stub
}
public Compte(String num, long montant ) {
	super();
	this.num = num;
	this.montant = montant;
	
	
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public long getMontant() {
	return montant;
}
public void setMontant(long l) {
	this.montant = l;
}

}
