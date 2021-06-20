package syskathelpproject.syskathelpproject.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class logiciel {
	@Id
@GeneratedValue
	public Long idL;
	
public String nom;
public String version;
public String tech;

@ManyToMany(mappedBy="logiciels")
private List<Client> clients;

public List<Client> getClients() {
	return clients;
}
public void setClients(List<Client> clients) {
	this.clients = clients;
}
@ManyToMany(mappedBy="logiciels1")
private List<Ingenieur> ingenieurs;

public List<Ingenieur> getIngenieurs() {
	return ingenieurs;
}
public void setingenieurs(List<Ingenieur> ingenieurs) {
	this.ingenieurs = ingenieurs;
}

public Long getId() {
	return idL;
}
public String getVersion() {
	return version;
}
public void setVersion(String version) {
	this.version = version;
}
public void setId(Long idL) {
	this.idL = idL;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getTech() {
	return tech;
}
public void setTech(String tech) {
	this.tech = tech;
}
public logiciel()
{}

public logiciel(Long id, String nom,String version,String tech) {
	
	this.idL = id;
	this.nom = nom;
	this.version=version;
	this.tech=tech;
}
public logiciel( String nom) {
	
	this.nom = nom;
	
}



}
