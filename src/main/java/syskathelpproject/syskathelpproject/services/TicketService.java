package syskathelpproject.syskathelpproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import syskathelpproject.syskathelpproject.dao.TicketRepository;

import syskathelpproject.syskathelpproject.entities.Ticket;



@Service
@Transactional
public class TicketService {
	
	 @Autowired
	    private TicketRepository ticketrepository;
	 
	
	


	    public void saveTicket(Ticket Ticket) {
	    	ticketrepository.save(Ticket);
	    }
	    public void deleteTicket(Ticket Ticket) {
	    	ticketrepository.delete(Ticket);
	    }

	   
	    public void deleteTicket(Long idL) {
	    	ticketrepository.deleteById(idL);
	    }
	    
	  

	    
	    public Ticket getTicketById(Long idL) {
	    	Optional<Ticket> optional = ticketrepository.findById(idL);
	    	Ticket Ticket = null;
	    	if(optional.isPresent()) {
	    		Ticket= optional.get();	    		
	    	}else {
	    		throw new RuntimeException("Ticket not found");
	    	}
	    	
	    	return Ticket;	
	    }
	    
	    public Page<Ticket> findPagination(int pageNo, int pagesize,String mc){
	    	
	    	Pageable pageable= PageRequest.of(pageNo - 1, pagesize);
	    	
	    	return this.ticketrepository.findAll(mc,pageable);
	    }
	    
  public List<Ticket>  findAll(){
	    	
	    
	    	
	    	return ticketrepository.findAll();
	    }
	    
	  
	   
	    

}