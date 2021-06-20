package syskathelpproject.syskathelpproject.entities;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Ingenieur {
	@Id
	@GeneratedValue
	int idI;
String nom;
String prenom;
public String email ;
public int telephone;
@ManyToMany
@JoinTable(name="ing_logiciel",joinColumns = 
@JoinColumn(name="idIng"),inverseJoinColumns =@JoinColumn(name="idL"))
public List<logiciel> logiciels1;
public List<logiciel> getLogiciels() {
	return logiciels1;
}
public void setLogiciels( List<logiciel> logiciels1) {
	this.logiciels1 = logiciels1;
}
public Ingenieur() {}

public Ingenieur(int idI, String nom, String prenom,String email, int telephone) {
	super();
	this.idI = idI;
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
public int getTelephone() {
	return telephone;
}
public void setTelephone(int telephone) {
	this.telephone = telephone;
}


}
