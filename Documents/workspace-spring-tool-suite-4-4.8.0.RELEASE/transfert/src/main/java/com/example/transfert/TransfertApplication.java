package com.example.transfert;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;

import com.example.transfert.dao.ClientRepository;
import com.example.transfert.dao.CompteRepository;
import com.example.transfert.entities.Client;
import com.example.transfert.entities.Compte;
import com.example.transfert.metier.TransfertMetierImp;

@SpringBootApplication
public class TransfertApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(TransfertApplication.class, args);
		TransfertMetierImp cr = ctx.getBean(TransfertMetierImp.class);
		
		cr.addClient(new Client("ek" ,"fatma" , "fatmaek@gmail.com","30602002"));
		cr.addClient(new Client("ali" ,"khadjetou" , "khadbetou@gmail.com","34343456"));
		cr.addClient(new Client("abd" ,"zeina" , "zeina@gmail.com","46460001"));
		cr.addClient(new Client("med" ,"toutou" , "toutoumed@gmail.com","436020022"));
		cr.addClient(new Client("sidi" ,"med" , "sidi@gmail.com","20203333"));
		cr.addClient(new Client("lol" ,"fufu" , "fatmaek@gmail.com","45454567"));
		cr.addClient(new Client("ahmed" ,"zahra" , "zahra@gmail.com","34343456"));
		cr.addClient(new Client("abd" ,"lili" , "lili@gmail.com","35363738"));
		cr.addClient(new Client("med" ,"tahya" , "tahya@gmail.com","23232345"));
		cr.addClient(new Client("sidahmed" ,"ethman" , "ethman@gmail.com","46474849"));
		
		cr.addCompte(new Compte("1234",10000),1L);
		cr.addCompte(new Compte("1235",30000),1L);
		cr.addCompte(new Compte("1236",20000),2L);
		cr.addCompte(new Compte("1237",45000),3L);
		cr.addCompte(new Compte("1238",70000),4L);
		cr.addCompte(new Compte("1239",70000),5L);
		//Page<Client> ct =cr.findAll(new QPageRequest(0, 5));
		//ct.forEach(e->System.out.println(e.getNom()+"  "+e.getPrenom()+"  "+e.getEmail()+"  "+e.getTelephone()));
		//System.out.println("--------------------------------------------------------------");
		//Page<Client> ct1 =cr.chercherClients("ek",new QPageRequest(0, 5));
		//ct1.forEach(e->System.out.println(e.getNom()));
		//System.out.println("--------------------------------------------------------------");
		//List<Compte> co =cr1.findAll();
		//co.forEach(e->System.out.println(e.getNum()+"  "+e.getMontant()+"  "+e.getClient()));
		
		
		
	}

}
