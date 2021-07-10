package syskathelpproject.syskathelpproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import syskathelpproject.syskathelpproject.dao.ClientRepository;

import syskathelpproject.syskathelpproject.entities.Client;
import syskathelpproject.syskathelpproject.entities.Ticket;
import syskathelpproject.syskathelpproject.services.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RestApiControlleur {
	  @Autowired
	    private TicketService ticketservice;

    @Autowired
    private ClientRepository clientrepository;


    @GetMapping("/clients")
    public List<Client> ListDeClients(){ return clientrepository.findAll();}

    // get client by id rest api
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client cl = clientrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found id = " + id));
        return ResponseEntity.ok(cl);
    }
    
    @RequestMapping(value="/saveticket" , method= RequestMethod.POST)
	public void saveTicket(Ticket ticket){
		
		ticketservice.saveTicket(ticket);
	
	}
    

	  @GetMapping("/listticket")
	  public String viewticketPage(Model model) {
	   return findPaginated1(1,model,"");  
	  }
	  
	
	  @GetMapping(value="/listticket{pageNo}")
		public String findPaginated1( @PathVariable(value = "pageNo") int pageNo,Model model,@RequestParam(name="motCle",defaultValue="")String mc){//,@PathVariable(value = "pageSize") int pageSize) {
		int  pageSize=5;
		
			Page <Ticket> page = ticketservice.findPagination(pageNo,pageSize,"%"+mc+"%");
			List<Ticket> tickets = page.getContent();	
			model.addAttribute("CurrentPage",pageNo);
			model.addAttribute("totalPages",page.getTotalPages());
			model.addAttribute("totalItems",page.getTotalElements());
			model.addAttribute("tickets",tickets);
			model.addAttribute("motCle",mc);
			return "listticket";
			}
	 


}