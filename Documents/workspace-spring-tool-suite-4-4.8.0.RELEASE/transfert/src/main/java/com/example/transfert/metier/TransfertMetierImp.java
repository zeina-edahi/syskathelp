package com.example.transfert.metier;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.transfert.dao.ClientRepository;
import com.example.transfert.dao.CompteRepository;
import com.example.transfert.entities.Client;
import com.example.transfert.entities.Compte;
import com.example.transfert.metier.transfertMetier;
@Component
public class TransfertMetierImp implements transfertMetier{
	@Autowired
 ClientRepository clientrepository;
	@Autowired
	CompteRepository compterepository;

	
	public Client addClient(Client c) {
		clientrepository.save(c);
		return c;
	}

	
	public Compte addCompte(Compte cp,long idC){
		Client c = clientrepository.getOne(idC);
		
		 cp.setClient(c);
		 compterepository.save(cp);
		return cp;
		}
	

	
	public void versser(String num, Long montant) {
		if(num==null)throw new RuntimeException("Compte introuvable");
		compterepository.versser(num, montant);
		
	}

	
	public void retirer(String num, Long montant) {
		if(num==null)throw new RuntimeException("Compte introuvable");
		compterepository.retirer(num, montant);
		
	}

	
	public void virer(String num, String num1, Long montant) {
		if(num==null && num1==null)throw new RuntimeException("Comptes introuvables");
		compterepository.retirer(num, montant);
		compterepository.versser(num1,montant);
		
	}

	
	
	public List<Compte> getCompteByClient(Long id){
		return clientrepository.getCompteByClient(id);
	}
	


}
