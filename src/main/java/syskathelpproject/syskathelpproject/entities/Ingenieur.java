package syskathelpproject.syskathelpproject.entities;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Ingenieur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idI;
public Long getIdI() {
		return idI;
	}
	public void setIdI(Long idI) {
		this.idI = idI;
	}
public String noming;

String prenom;
public String email ;
public int telephone;
@ManyToMany
@JoinTable(name="ing_logiciel",joinColumns = 
@JoinColumn(name="idI"),inverseJoinColumns =@JoinColumn(name="idL"))
public List<logiciel> logiciels1;
public List<logiciel> getLogiciels() {
	return logiciels1;
}
public void setLogiciels( List<logiciel> logiciels1) {
	this.logiciels1 = logiciels1;
}
public Ingenieur() {}
public String getNoming() {
	return noming;
}
public void setNoming(String noming) {
	this.noming = noming;
}
public Ingenieur(String noming, String prenom,String email, int telephone) {
	super();
	
	this.noming = noming;
	this.prenom = prenom;
	this.email = email;
	this.telephone = telephone;
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
