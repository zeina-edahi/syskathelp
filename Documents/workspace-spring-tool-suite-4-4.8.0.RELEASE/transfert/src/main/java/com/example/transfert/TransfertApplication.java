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

@SpringBootApplication
public class TransfertApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(TransfertApplication.class, args);
		ClientRepository cr = ctx.getBean(ClientRepository.class);
		cr.save(new Client(1,"ek" ,"fatma" , "fatmaek@gmail.com","30602002"));
		cr.save(new Client(2 ,"abd" ,"zeina" , "zeina@gmail.com","36959539"));
		cr.save(new Client(3 ,"ali" ,"khadjetou" , "khadjetou@gmail.com","38515258"));
		cr.save(new Client(4 ,"med" ,"toutou" , "toutou@gmail.com","38515258"));
		cr.save(new Client(5 ,"sidi" ,"meymouna" , "meymouna@gmail.com","48810851"));
		cr.save(new Client(6,"ek" ,"fatma" , "fatmaek@gmail.com","30602002"));
		cr.save(new Client(7 ,"ethman" ,"fatu" , "fatu@gmail.com","36959539"));
		cr.save(new Client(8 ,"ali" ,"mariem" , "mariem@gmail.com","38515258"));
		cr.save(new Client(9 ,"hbib" ,"brahim" , "brahim@gmail.com","34567889"));
		cr.save(new Client(10 ,"ahmed" ,"sid" , "sid@gmail.com","46464600"));
		cr.save(new Client(11,"ew" ,"fatima" , "fatima@gmail.com","34356786"));
		cr.save(new Client(12,"ethman" ,"fatu" , "fatu@gmail.com","36959539"));
		cr.save(new Client(13 ,"ali" ,"mariem" , "mariem@gmail.com","38515258"));
		cr.save(new Client(14 ,"hamed" ,"him" , "ahim@gmail.com","45678934"));
		cr.save(new Client(15 ,"med" ,"sid" , "sid@gmail.com","46464600"));
	   //cr.deleteById((long) 1);
	  
		CompteRepository cr1 = ctx.getBean(CompteRepository.class);
		cr1.save(new Compte("1234", 10000));
		cr1.save(new Compte("1235", 2000));
		cr1.save(new Compte("1236", 2300));
		cr1.save(new Compte("1237", 10345567));
		cr1.save(new Compte("1238", 205678));
		cr1.save(new Compte("1239", 23345));
		cr1.deleteById("1234");
		
		Page<Client> ct =cr.findAll(new QPageRequest(0, 5));
		ct.forEach(e->System.out.println(e.getNom()+"  "+e.getPrenom()+"  "+e.getEmail()+"  "+e.getTelephone()));
		System.out.println("--------------------------------------------------------------");
		Page<Client> ct1 =cr.chercherClients("ek",new QPageRequest(0, 5));
		ct1.forEach(e->System.out.println(e.getNom()));
		System.out.println("--------------------------------------------------------------");
		List<Compte> co =cr1.findAll();
		co.forEach(e->System.out.println(e.getNum()+"  "+e.getMontant()+"  "+e.getClient()));
		
		
		
	}

}
