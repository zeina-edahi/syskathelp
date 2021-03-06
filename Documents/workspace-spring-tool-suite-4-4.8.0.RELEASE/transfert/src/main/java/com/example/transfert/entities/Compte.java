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
private int clientid;
public int getClientid() {
	return clientid;
}
public void setClientid(int clientid) {
	this.clientid = clientid;
}
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
	//super();
	this.num = num;
	this.montant = montant;
		
}
public Compte(String num, long montant,int clientid ) {
	//super();
	this.num = num;
	this.montant = montant;
	this.clientid=clientid;	
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



public void verser(Compte compte, long montant) {
	compte.montant= compte.montant+montant;
	
}
public void retirer(Compte compte, long montant) {
	compte.montant= compte.montant-montant;
	
}
public void virement(Compte compte1, Compte compte2, long montant) {

	if (compte1.equals(compte2)) {
		throw new RuntimeException("Impossibile de faire un virement sur le même compte");
	}

	retirer(compte1, montant);
	verser(compte2, montant);
}
}