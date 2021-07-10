package syskathelpproject.syskathelpproject.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idT;
	private Date date;
	private String etat;
	private String commentaire;
	
	@ManyToOne
    @JoinColumn(name="idC")
    private Client client;

	public Long getIdT() {
		return idT;
	}

	public void setIdT(Long idT) {
		this.idT = idT;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Ticket(Long idT, Date date, String etat, String commentaire, Client client) {
		super();
		this.idT = idT;
		this.date = date;
		this.etat = etat;
		this.commentaire = commentaire;
		this.client = client;
	}

	public Ticket() {
		super();
	}

	@Override
	public String toString() {
		return "Ticket [idT=" + idT + ", date=" + date + ", etat=" + etat + ", commentaire=" + commentaire + ", client="
				+ client.getNomcomplet() + client.getnomsociete()+ "]";
	}

	


}
