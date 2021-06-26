package syskathelpproject.syskathelpproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import syskathelpproject.syskathelpproject.dao.LogicielRepository;

import syskathelpproject.syskathelpproject.entities.logiciel;



@Service
@Transactional
public class LogicielService {
	
	 @Autowired
	    private LogicielRepository logicielrepository;
	 
	
	


	    public void savelogiciel(logiciel logiciel) {
	    	logicielrepository.save(logiciel);
	    }
	    public void deletelogiciel(logiciel logiciel) {
	    	logicielrepository.delete(logiciel);
	    }

	   
	    public void deletelogiciel(Long idL) {
	    	logicielrepository.deleteById(idL);
	    }
	    
	  

	    
	    public logiciel getlogicielById(Long idL) {
	    	Optional<logiciel> optional = logicielrepository.findById(idL);
	    	logiciel logiciel = null;
	    	if(optional.isPresent()) {
	    		logiciel= optional.get();	    		
	    	}else {
	    		throw new RuntimeException("logiciel not found");
	    	}
	    	
	    	return logiciel;	
	    }
	    
	    public Page<logiciel> findPagination(int pageNo, int pagesize){
	    	
	    	Pageable pageable= PageRequest.of(pageNo - 1, pagesize);
	    	
	    	return this.logicielrepository.findAll(pageable);
	    }
	    
	    
	  
	   
	    

}