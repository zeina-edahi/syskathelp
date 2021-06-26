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

import syskathelpproject.syskathelpproject.dao.IngenieurRepository;
import syskathelpproject.syskathelpproject.dao.LogicielRepository;
import syskathelpproject.syskathelpproject.entities.Ingenieur;
import syskathelpproject.syskathelpproject.entities.logiciel;
import syskathelpproject.syskathelpproject.services.IngenieurService;

@Controller

public class IngenieurController {
	
	@Autowired
	private IngenieurService  ingenieurservice;
	
@Autowired
private IngenieurRepository  ingenieurrepository;
@Autowired
private LogicielRepository  logicielrepository;
	
	@RequestMapping("/addingenieur")
	public String ajouteringenieurpage() {
		return "addingenieur";
	}

	@RequestMapping(value="/saveingenieur" , method= RequestMethod.POST)
	public String save(Ingenieur ingenieur){
		ingenieurrepository.save(ingenieur);
	
	return "redirect:listingenieur1";
	}  
	@RequestMapping(value="/supprimerI")
	 public String supprimerI(Long idI) { 
		   ingenieurrepository.deleteById(idI);
	
		   return "redirect:listingenieur1";
		   
	   }

	  
	
	  @RequestMapping(value="/editingenieur" )
		 public String editI(Long idI, Model model) {
		 
		  Ingenieur ingenieur = ingenieurrepository.getIngenieurById(idI);
		 
		   model.addAttribute("ingenieur", ingenieur);
		   return "editingenieur";
		   
	 }
	 
	  @PostMapping(value="/UpdateIngenieur" )
		public String updateIngenieur(Ingenieur  Ingenieur){
		Long idI = Ingenieur.getIdI();	
		Ingenieur.setIdI(idI);
		ingenieurrepository.save(Ingenieur);
		
		return "redirect:listingenieur1";
		
	 
	  } 
	   
	  @RequestMapping(value="/addingenieurtologiciel", method={RequestMethod.POST, RequestMethod.GET})
	  
		public String ajouterlogiciel(Long idI,Model model) {
			//Client client1 = clientrepository.getOne(ID);
		  List<logiciel> logiciels = logicielrepository.findAll();
			
		  Ingenieur ingenieur = ingenieurrepository.getIngenieurById(idI);
			model.addAttribute("ingenieur", ingenieur);
			model.addAttribute(ingenieur);
			model.addAttribute("logiciels",logiciels);
			model.addAttribute(logiciels);
			return "addingenieurtologiciel";
		}
	  
	  @GetMapping("/listingenieur")
	  public String viewHomePage(Model model) {
	   return findPaginated(1,model,"");  
	  }
	  
	
	  @GetMapping(value="/listingenieur{pageNo}")
		public String findPaginated( @PathVariable(value = "pageNo") int pageNo,Model model,@RequestParam(name="motCle",defaultValue="")String mc){//,@PathVariable(value = "pageSize") int pageSize) {
		int  pageSize=1;
			//Pageable pageable = PageRequest.of(p,1);
			Page<Ingenieur> page = ingenieurservice.findPagination(pageNo,pageSize,"%"+mc+"%");
			//@SuppressWarnings("deprecation")
			//Page<Client> page = clientrepository.findAll(pageable);
				List<Ingenieur> ingenieurs = page.getContent();
				
			//Page<Client> clients = clientrepository .chercherClients("%"+mc+"%",pageable);
		//	int pageCount=clients.getTotalPages();
			//int[] pages = new int[pageCount];
			//for(int i=0;i<pageCount;i++) pages[i]=i;
				
			model.addAttribute("CurrentPage",pageNo);
			model.addAttribute("totalPages",page.getTotalPages());
			model.addAttribute("totalItems",page.getTotalElements());
			model.addAttribute("ingenieurs",ingenieurs);
			model.addAttribute("motCle",mc);
			return "listingenieur";
			}
}
