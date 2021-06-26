package syskathelpproject.syskathelpproject.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import syskathelpproject.syskathelpproject.dao.ClientRepository;
import syskathelpproject.syskathelpproject.dao.IngenieurRepository;
import syskathelpproject.syskathelpproject.dao.LogicielRepository;
import syskathelpproject.syskathelpproject.entities.Client;
import syskathelpproject.syskathelpproject.entities.logiciel;
import syskathelpproject.syskathelpproject.services.ClientService;


@Controller

public class ClientController {
	@Autowired
	private ClientService clientservice;
	
	@Autowired
 private ClientRepository  clientrepository;
	
	@Autowired
 private LogicielRepository logicielrepository;
	
	@Autowired
	 private IngenieurRepository ingenieurrepository;
	
	@RequestMapping("/loging")
	public String loginpage() {
		return "index";
	}
	@RequestMapping(value="/dashboard")
	public String dashboardpage(Model model) {
		long numberclient = clientrepository.count();
		long numberlogiciel = logicielrepository.count();
		long numberingenieur = ingenieurrepository.count();
		model.addAttribute("numberlogiciel",numberlogiciel);
		model.addAttribute(numberlogiciel);
		model.addAttribute("numberclient",numberclient);
		model.addAttribute(numberclient);
		model.addAttribute("numberingenieur",numberingenieur);
		model.addAttribute(numberingenieur);
		return "dashboard";
	}

	
	
	@RequestMapping(value="/listclient/{idC}")
	public String listclientpage(Model model) {
		
		List<Client> clients =clientrepository.findAll();
		List<logiciel> logiciels =logicielrepository.findAll();
		model.addAttribute("clients",clients);
		model.addAttribute("logiciels",logiciels);
		return "";
	}
	@RequestMapping("/addclient")
	public String ajouterclientpage() {
		return "addclient";
	}
	@RequestMapping(value="/saveclient" , method= RequestMethod.POST)
	public String save(Client client){
	 clientrepository.save(client);
	
	return "redirect:listclient1";
	}
	  @RequestMapping(value="/supprimer")
		 public String supprimer(Long idC) { 
		   clientrepository.deleteById(idC);
	
		   return "redirect:listclient1";
		   
	   }

	  
	  @RequestMapping(value="/editclient" )
		 public String edit(Long idC, Model model) {
		 
		 //  Client client = clientrepository.getclientById(idC);
		   Client client = clientservice.getClientById(idC);
		   model.addAttribute("Client", client);
		   
		   return "editclient";
		   
	 }
	
	  @PostMapping(value="/UpdateClient" )
		public String update(Client Client){
		Long idC = Client.getIdC();
		  Client.setIdC(idC);
		 clientrepository.save(Client);
		
		return "redirect:listclient1";
		
	 
	  } 
	  
	
	
	  @RequestMapping(value="/addclienttologiciel", method={RequestMethod.POST, RequestMethod.GET})
	  
		public String ajouterlogicielpage(Long idC,Model model) {
			//Client client1 = clientrepository.getOne(ID);
		
			List<logiciel> logiciels = logicielrepository.findAll();
			Client client = clientrepository.getclientById(idC);
			model.addAttribute("Client", client);
			model.addAttribute(client);
			model.addAttribute("logiciels",logiciels);
			model.addAttribute(logiciels);
			return "addclienttologiciel";
		}
	 
	  @GetMapping("/listclient")
	  public String viewHomePage(Model model) {
	   return findPaginated(1,model);  
	  }
	  
	
	  @GetMapping(value="/listclient{pageNo}")
		public String findPaginated( @PathVariable(value = "pageNo") int pageNo,Model model){//,@PathVariable(value = "pageSize") int pageSize) {
		int  pageSize=2;
			//Pageable pageable = PageRequest.of(p,1);
			Page < Client> page = clientservice.findPagination(pageNo,pageSize);
			//@SuppressWarnings("deprecation")
			//Page<Client> page = clientrepository.findAll(pageable);
				List<Client> clients = page.getContent();
				
			//Page<Client> clients = clientrepository .chercherClients("%"+mc+"%",pageable);
		//	int pageCount=clients.getTotalPages();
			//int[] pages = new int[pageCount];
			//for(int i=0;i<pageCount;i++) pages[i]=i;
				
			model.addAttribute("CurrentPage",pageNo);
			model.addAttribute("totalPages",page.getTotalPages());
			model.addAttribute("totalItems",page.getTotalElements());
			model.addAttribute("clients",clients);
	
			return "listclient";
			}
	  
	
}
