package syskathelpproject.syskathelpproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import syskathelpproject.syskathelpproject.dao.ClientRepository;
//import syskathelpproject.syskathelpproject.dao.LogicielRepository;
import syskathelpproject.syskathelpproject.entities.Client;



@Service
@Transactional
public class ClientService {
	 @Autowired
	    private ClientRepository clientrepository;
	// @Autowired
	  //  private LogicielRepository logicielrepository;
	 
	
	


	    public void saveCustomer(Client client) {
	    	clientrepository.save(client);
	    }
	    public void deletecustomer(Client client) {
	    	clientrepository.delete(client);
	    }

	   
	    public void deleteCustomer(Long idC) {
	    	clientrepository.deleteById(idC);
	    }
	    
	    public Client getCustomer(Long idC) {
	    	
	    	return clientrepository.getOne(idC); 	
	    }	

	    
	    public Client getClientById(Long idC) {
	    	Optional<Client> optional = clientrepository.findById(idC);
	    	Client client = null;
	    	if(optional.isPresent()) {
	    		client= optional.get();	    		
	    	}else {
	    		throw new RuntimeException("Client not found");
	    	}
	    	
	    	return client;	
	    }
	    
	    public Page<Client> findPagination(int pageNo, int pagesize){
	    	
	    	Pageable pageable= PageRequest.of(pageNo - 1, pagesize);
	    	
	    	return this.clientrepository.findAll(pageable);
	    }
	    
	    
	  
	   
	    

}