package syskathelpproject.syskathelpproject.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import syskathelpproject.syskathelpproject.dao.LogicielRepository;

import syskathelpproject.syskathelpproject.entities.logiciel;
import syskathelpproject.syskathelpproject.services.LogicielService;


@Controller

public class LogicielController {
	

	
	@Autowired
	private LogicielRepository  logicielrepository;
	

	@Autowired
	private LogicielService  logicielservice;
	

	
	@RequestMapping(value="/savelogiciel" , method= RequestMethod.POST)
	public String save(logiciel logiciel){
		
		logicielrepository.save(logiciel);
	
	return "redirect:listlogiciel1";
	}
	
	
	@RequestMapping(value="/addlogiciel")
	public String ajouterlogicielpage() {
		
		return "addlogiciel1";
	}
	
	
	
	  @RequestMapping(value="/supprimerL")
		 public String supprimerL(Long idL) { 
		   logicielrepository.deleteById(idL);
	
		   return "redirect:listlogiciel1";
		   
	   }
	
	

	  @RequestMapping(value="/editlogiciel" )
		 public String editL(Long idL, Model model) {
		 
		   logiciel logiciel1 = logicielrepository.getlogicielById(idL);
		 
		   model.addAttribute("logiciel", logiciel1);
		   return "editlogiciel";
		   
	 }
	 
	  
 
	  @PostMapping(value="/UpdateLogiciel" )
			public String updateLogiciel(logiciel Logiciel){
			Long idL = Logiciel.getIdL();	
			Logiciel.setIdL(idL);
			logicielrepository.save(Logiciel);
			
			return "redirect:listlogiciel1";
			
		 
		  } 
	  @RequestMapping(value="/listlogiciel")
		public String listlogicielpage(Model model ,@RequestParam(name="page",defaultValue="0")int p,
				@RequestParam(name="motCle",defaultValue="")String mc) {
		
			Pageable pageable = PageRequest.of(p,7);
			//@SuppressWarnings("deprecation")
			//Page<Client> clients = clientrepository.findAll(new QPageRequest(p,5));
			Page<logiciel> logiciels = logicielrepository.chercherlogiciels("%"+mc+"%",pageable);
			int pageCount=logiciels.getTotalPages();
			int[] pages = new int[pageCount];
			for(int i=0;i<pageCount;i++) pages[i]=i;
			model.addAttribute("pages",pages);
			model.addAttribute("logiciels",logiciels);
			model.addAttribute("pageCourante",p);
			model.addAttribute("motCle",mc);
			return "listlogiciel";
			}
	  @RequestMapping(value="/saveclientlogiciel" , method={RequestMethod.POST, RequestMethod.GET})
			public String saveclientlogiciel(Long idC,Long idL){
		  
			 logicielrepository.addlogicieltoclient(idC,idL);
			  
			return "redirect:listclient1";
			   }
	  
	  @RequestMapping(value="/saveingnieurlogiciel" , method={RequestMethod.POST, RequestMethod.GET})
		public String saveingenieurlogiciel(Long idI,Long idL){
	  
		 logicielrepository.addlogicieltoingenieur(idI, idL);
		  
		return "redirect:listingenieur";
		   }
	  @GetMapping("/listlogiciel")
	  public String viewHomePage(Model model) {
	   return findPaginated(1,model);  
	  }
	  
	
	  @GetMapping(value="/listlogiciel{pageNo}")
		public String findPaginated( @PathVariable(value = "pageNo") int pageNo,Model model){//,@PathVariable(value = "pageSize") int pageSize) {
		int  pageSize=1;
			//Pageable pageable = PageRequest.of(p,1);
			Page < logiciel> page = logicielservice.findPagination(pageNo,pageSize);
			//@SuppressWarnings("deprecation")
			//Page<logiciel> page = logicielrepository.findAll(pageable);
				List<logiciel> logiciels = page.getContent();
				
			//Page<Client> clients = clientrepository .chercherClients("%"+mc+"%",pageable);
		//	int pageCount=clients.getTotalPages();
			//int[] pages = new int[pageCount];
			//for(int i=0;i<pageCount;i++) pages[i]=i;
				
			model.addAttribute("CurrentPage",pageNo);
			model.addAttribute("totalPages",page.getTotalPages());
			model.addAttribute("totalItems",page.getTotalElements());
			model.addAttribute("logiciels",logiciels);
	
			return "listlogiciel";
			}
	 
}
