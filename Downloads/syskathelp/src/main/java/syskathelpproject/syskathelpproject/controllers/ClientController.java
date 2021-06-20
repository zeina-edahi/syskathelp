package syskathelpproject.syskathelpproject.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import syskathelpproject.syskathelpproject.dao.ClientRepository;
import syskathelpproject.syskathelpproject.dao.IngenieurRepository;
import syskathelpproject.syskathelpproject.dao.LogicielRepository;
import syskathelpproject.syskathelpproject.entities.Client;
import syskathelpproject.syskathelpproject.entities.logiciel;
import syskathelpproject.syskathelpproject.services.ClientService;
import syskathelpproject.syskathelpproject.entities.Ingenieur;

@Controller

public class ClientController {
	@Autowired
	private ClientService clientservice;
	
	@Autowired
 private ClientRepository  clientrepository;
	@Autowired
private IngenieurRepository  ingenieurrepository;
	
	@Autowired
	private LogicielRepository  logicielrepository;
	
	@RequestMapping("/loging")
	public String loginpage() {
		return "index";
	}
	@RequestMapping("/dashboard")
	public String dashboardpage() {
		return "dashboard";
	}
	@RequestMapping("/accueil")
	public String accueilpage() {
		return "accueil";
	}
	@RequestMapping("/listc")
	public String page() {
		return "listc";
	}
	
	
	@RequestMapping(value="/listclient")
	public String listclientpage(Model model) {
		List<Client> clients =clientrepository.findAll();
		List<logiciel> logiciels =logicielrepository.findAll();
		model.addAttribute("clients",clients);
		model.addAttribute("logiciels",logiciels);
		return "listclient";
	}
	@RequestMapping("/addclient")
	public String ajouterclientpage() {
		return "addclient";
	}
	@RequestMapping(value="/saveclient" , method= RequestMethod.POST)
	public String save(Client client){
	 clientrepository.save(client);
	
	return "redirect:listclient";
	}
	
	@RequestMapping("/addingenieur")
	public String ajouteringenieurpage() {
		return "addingenieur";
	}
	@RequestMapping(value="/listingenieur")
	public String listingenieurpage(Model model) {
		List<Ingenieur> ingenieurs =ingenieurrepository.findAll();
		model.addAttribute("ingenieurs",ingenieurs);
		return "listingenieur";
	}
	@RequestMapping(value="/saveingenieur" , method= RequestMethod.POST)
	public String save(Ingenieur ingenieur){
		ingenieurrepository.save(ingenieur);
	
	return "redirect:listingenieur";
	}
	@RequestMapping(value="/savelogiciel" , method= RequestMethod.POST)
	public String save(logiciel logiciel){
		
		logicielrepository.save(logiciel);
	
	return "redirect:listclient";
	}
	
	@RequestMapping(value="/addlogiciel", method={RequestMethod.POST, RequestMethod.GET})
	public String ajouterlogicielpage(Long ID,Model model,logiciel logiciel) {
		//Client client1 = clientrepository.getOne(ID);
		
		Client client = clientrepository.getById(ID);
		model.addAttribute("Client", client);
		model.addAttribute(client);
		return "addlogiciel";
	}
	
	@RequestMapping(value="/listlogiciel")
	public String listlogicielpage(Model model) {
		List<logiciel> logiciels = logicielrepository.findAll();
		model.addAttribute("logiciels",logiciels);
		return "listlogiciel";
	}
	
	
	
	  /*@RequestMapping(value="/updatelogiciel" , method={RequestMethod.POST, RequestMethod.GET})
		public String updatecompte(Long ID,logiciel logiciel){
		 
		  Client client1 = clientrepository.getById(ID); 
		  logiciel.setClients((Collection<Client>) client1);
		logicielrepository.save(logiciel);
		return "redirect:listlogiciel";
		   }*/
	  
	  @RequestMapping(value="/supprimer")
		 public String supprimer(Long ID) {
		
		  logicielrepository.deleteById(ID); 
		   clientrepository.deleteById(ID);
	
		   return "redirect:listclient";
		   
	   }
	  
	  @RequestMapping(value="/editclient" )
		 public String edit(Long ID, Model model) {
		 
		   Client client = clientrepository.getclientById(ID);
		 
		   model.addAttribute("Client", client);
		   return "editclient";
		   
	 }
	   @RequestMapping(value="/UpdateClient" , method={RequestMethod.POST, RequestMethod.GET})
		public String update(Client Client){
		
		 clientrepository.save(Client);
		
		return "redirect:listclient";
		
	   }
	 
	    @DeleteMapping("/UpdateClient")
	    public void delete(@PathVariable Long ID) {

	    	clientservice.deleteCustomer(ID);
	    }
	   

}
