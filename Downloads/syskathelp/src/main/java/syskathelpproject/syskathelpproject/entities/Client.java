package syskathelpproject.syskathelpproject.entities;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;





@Entity
public class Client {
	@Id
	@GeneratedValue
	public Long idC ;
	public Long getID() {
		return idC;
	}
	public void setID(Long idC) {
		this.idC = idC;
	}
	public String nom;
	public String nomsociete ; 
	public String email ;
	public	String address;
	public	String motdepasse;
	public int telephone;
	@ManyToMany
	@JoinTable(name="client_logiciel",joinColumns = 
    @JoinColumn(name="idC"),inverseJoinColumns =@JoinColumn(name="idL"))
	private List<logiciel> logiciels;

	public List<logiciel> getLogiciels() {
		return logiciels;
	}
	public void setLogiciels( List<logiciel> logiciels) {
		this.logiciels = logiciels;
	}

	public Client() {

	}
	public Client(String nom, String motdepasse, String email, String address, String nomsociete, int telephone) {
		super();
		this.nom = nom;
		this.motdepasse = motdepasse;
		this.email = email;
		this.address = address;
		this.nomsociete = nomsociete;
		this.telephone = telephone;
		
	}
	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	public String getmotdepasse() {
		return motdepasse;
	}
	public void setmotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getnomsociete() {
		return nomsociete;
	}
	public void setnomsociete(String nomsociete) {
		this.nomsociete = nomsociete;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return   nomsociete;
	}

}
