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
import org.springframework.web.bind.annotation.RequestParam;

import syskathelpproject.syskathelpproject.dao.ClientRepository;
import syskathelpproject.syskathelpproject.dao.IngenieurRepository;
import syskathelpproject.syskathelpproject.dao.LogicielRepository;
import syskathelpproject.syskathelpproject.dao.TicketRepository;
import syskathelpproject.syskathelpproject.entities.Client;
import syskathelpproject.syskathelpproject.entities.logiciel;
import syskathelpproject.syskathelpproject.services.ClientService;
import syskathelpproject.syskathelpproject.services.EmailService;
import syskathelpproject.syskathelpproject.services.TicketService;



@Controller

public class ClientController {
	

	    
	@Autowired
	private ClientService clientservice;
	
	@Autowired
	private EmailService emailservice;
	
	@Autowired
	private TicketService ticketservice;
	@Autowired
	private TicketRepository ticketrepository;
	
	@Autowired
 private ClientRepository  clientrepository;
	
	@Autowired
 private LogicielRepository logicielrepository;
	
	@Autowired
	 private IngenieurRepository ingenieurrepository;
	
	

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
	String toEmail= client.getEmail();
	String password = client.getmotdepasse();
	System.out.println(toEmail);
	emailservice.sendEmail(toEmail,password);
	
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
	   return findPaginated(1,model,"");  
	  }
	  
	
	  @GetMapping(value="/listclient{pageNo}")
		public String findPaginated( @PathVariable(value = "pageNo") int pageNo,Model model,@RequestParam(name="motCle",defaultValue="")String mc){//,@PathVariable(value = "pageSize") int pageSize) {
		int  pageSize=5;
			
			Page < Client> page = clientservice.findPagination(pageNo,pageSize,"%"+mc+"%");	
				List<Client> clients = page.getContent();		
			model.addAttribute("CurrentPage",pageNo);
			model.addAttribute("totalPages",page.getTotalPages());
			model.addAttribute("totalItems",page.getTotalElements());
			model.addAttribute("clients",clients);
			model.addAttribute("motCle",mc);
			return "listclient";
			}
	  
	  @RequestMapping(value="/listclientlogiciel", method={RequestMethod.POST, RequestMethod.GET})
	  
		public String listeclientlogiciel(Long idC,Model model) {
			//Client client1 = clientrepository.getOne(ID);
		
			List<String> logiciel = logicielrepository.nomlogicielclient(idC);
			
			Client client = clientrepository.getclientById(idC);
			
			String nomsociete = client.getnomsociete();
			model.addAttribute("logiciel",logiciel);
			model.addAttribute(logiciel);
			model.addAttribute("nomsociete",nomsociete);
			model.addAttribute(nomsociete);
			return "listclientlogiciel";
		}
	  
	
	}

