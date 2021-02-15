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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Controller
@RequestMapping("/client")
public class TransfertController {
	@Autowired
private ClientRepository clientrepository;
	@Autowired
	private CompteRepository compterepository;
	
	@RequestMapping("/index")
	public String index(Model model,@RequestParam(name="p",defaultValue="0")int p, @RequestParam(name="motCle",defaultValue="")String mc){
		
	//Page<Client> lc = clientrepository.chercherClients("%"+mc+"%", new  QPageRequest(p,10));
		//Page<Client> lc = clientrepository.chercherClients(mc, new   QPageRequest(p, 5));
		Page<Client> lc = clientrepository.findAll(new QPageRequest(p, 10));
		int pC=lc.getTotalPages();
		int[] pages = new int[pC];
		for(int i=0;i<pC;i++)pages[i]=i;
		model.addAttribute("pages",pages);
		model.addAttribute("clients",lc);
		model.addAttribute("pageCourante",p);
		model.addAttribute("motCle",mc);
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
		   clientrepository.deleteById(id);
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
	   
	 
	   @RequestMapping(value="/compte")
	   public String index1(Model model,@RequestParam(name="p1",defaultValue="0")int p1){
			Page<Compte> lc = compterepository.findAll(new QPageRequest(p1, 10));
			int pC=lc.getTotalPages();
			int[] pages = new int[pC];
			for(int i=0;i<pC;i++)pages[i]=i;
			model.addAttribute("pages",pages);
			model.addAttribute("compte",lc);	
			model.addAttribute("pageCourante",p1);
			
			return "Compte";
			}
}
	
	
