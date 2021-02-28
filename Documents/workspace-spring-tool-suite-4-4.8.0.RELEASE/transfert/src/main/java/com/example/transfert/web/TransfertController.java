package com.example.transfert.web;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.transfert.dao.ClientRepository;
import com.example.transfert.dao.CompteRepository;
import com.example.transfert.entities.Client;
import com.example.transfert.entities.Compte;
import com.example.transfert.metier.TransfertMetierImp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Controller
@RequestMapping("/client")
public class TransfertController {
	@Autowired
private ClientRepository clientrepository;
	@Autowired
	private TransfertMetierImp transfertmetier;
	@Autowired
	private CompteRepository compterepository;
	
	@RequestMapping("/index")
	public String index(Model model ,@RequestParam(name="page",defaultValue="0")int p) {
	//Page<Client> lc = clientrepository.chercherClients("%"+mc+"%", new  QPageRequest(p,10));
		//Page<Client> lc = clientrepository.chercherClients(mc, new   QPageRequest(p, 5));
		Page<Client> lc = clientrepository.findAll(new QPageRequest(p,100));
		int pC=lc.getTotalPages();
		int[] pages = new int[pC];
		for(int i=0;i<pC;i++) pages[i]=i;
		model.addAttribute("pages",pages);
		model.addAttribute("clients",lc);
		model.addAttribute("pageCourante",p);
	
		return "client";
		}
	
	 @RequestMapping(value="/form" , method= RequestMethod.GET)
		public String formclient(Model model){
		model.addAttribute("Client", new Client());
		return "formclient";
		}
		 @RequestMapping(value="/saveClient" , method= RequestMethod.POST)
			public String save(Client client){
			// clientrepository.save(client);
			clientrepository.save(client);
			return "redirect:index";
			}
	   @RequestMapping(value="/supprimer")
		 public String supprimer(long id) {
		  // Compte c = compterepository.getOne(id);
		   compterepository.deleteById(id);
		   clientrepository.deleteById(id);
		 
		   
		 //  clientrepository.deleteById(id);
		 //  clientrepository.deleteById(id);
		   return "redirect:index";
		   
	   }
	   @RequestMapping(value="/edit" )
		 public String edit(long id, Model model) {
		 //  Client client = clientrepository.findById(id);
		   Client client1 = clientrepository.getOne(id);
		 //  Client client = clientrepository.getOne(id);
		//   Client client = clientrepository.getOne();
		 //  model.addAttribute("Client", client);
		  // model.addAttribute("Client", client);
		   model.addAttribute("Client", client1);
		   return "editform";
		   
	 }
	   @RequestMapping(value="/UpdateClient" , method= RequestMethod.POST)
		public String update(Client Client){
		 clientrepository.save(Client);
		
		
		return "redirect:index";
		
	   }
	   
	   
	   @RequestMapping("/compte")
		public String compte(Model model,@RequestParam(name="page",defaultValue="0")int c){
		   
			@SuppressWarnings("deprecation")
			Page<Compte> pagecomptes = compterepository.findAll(new QPageRequest(c,10));
			Page<Compte> pagecompte = compterepository.findAll(new QPageRequest(c, 2));
			int pagescount=pagecomptes.getTotalPages();
			int[] pages = new int[pagescount];
			for(int i=0;i<pagescount;i++)pages[i]=i;
			model.addAttribute("Comptes",pagecomptes);
			model.addAttribute("pages",pages);
			model.addAttribute("pageComptes",pagecomptes);
		
			return "compte";
			
			}
	   
	  
	   @RequestMapping(value="/retirer" , method= RequestMethod.GET)
		public String retirer(String compte1,long montant){
		 transfertmetier.retirer(compte1, montant);
		return "redirect:compte";
	   }
	   @RequestMapping(value="/versser" , method= RequestMethod.GET)
	 		public String versser(String compte1,long montant){
	 		 compterepository.versser(compte1, montant);
	 		return "redirect:compte";
	 		
	 	   }
	   @RequestMapping(value="/virement" , method= RequestMethod.GET)
		public String virement(String compte1,String compte2,long montant){
		 compterepository.retirer(compte1, montant);
		 compterepository.versser(compte2, montant);
		return "redirect:compte";
		
	   }
	   
	   @RequestMapping(value="/operation" , method= RequestMethod.GET)
		public String operation(){
		//model.addAttribute("Client", new Client());
		return "operation";
		}
	   
	   @RequestMapping(value="/retir" , method= RequestMethod.GET)
	 		public String retir(){
	 		//model.addAttribute("Client", new Client());
	 		return "retirer";
	 		}
	   @RequestMapping(value="/vers" , method= RequestMethod.GET)
		public String vers(){
		//model.addAttribute("Client", new Client());
		return "versser";
		}
	   @RequestMapping(value="/vir" , method= RequestMethod.GET)
		public String vir(){
		//model.addAttribute("Client", new Client());
		return "virement";
		}

	   
	  
	   @RequestMapping(value="/saveCompte", method= RequestMethod.POST)
		public String saveCompte(Compte compte){
		 compterepository.save(compte);
		 //transfertmetier.addCompte(compte,id);
			return "redirect:index";
		
		}
	   @RequestMapping(value="/formcompte" , method= RequestMethod.GET)
		public String formcompte(Model model){
		model.addAttribute("Compte", new Compte());
		return "formcompte";
		}
}
	
	
