package com.example.transfert.metier;

import com.example.transfert.entities.Client;
import com.example.transfert.entities.Compte;

public interface transfertMetier {
	public Client addClient(Client c);
	public Compte addCompte(Compte cp,long idC);
	public void versser(String num,Long montant);
	public void retirer(String num,Long montant);
	public void virer(String num2,String num1,Long montant);
}
