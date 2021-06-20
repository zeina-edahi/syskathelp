package syskathelpproject.syskathelpproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import syskathelpproject.syskathelpproject.dao.ClientRepository;
import syskathelpproject.syskathelpproject.entities.Client;


@Service
@Transactional
public class ClientService {
	 @Autowired
	    private ClientRepository clientrepository;
	 



	    public void saveCustomer(Client client) {
	    	clientrepository.save(client);
	    }

	   
	    public void deleteCustomer(Long ID) {
	    	clientrepository.deleteById(ID);
	    }
	    public Client getCustomer(Long ID) {
	    	return clientrepository.getOne(ID);
	    
	
	    }	

}