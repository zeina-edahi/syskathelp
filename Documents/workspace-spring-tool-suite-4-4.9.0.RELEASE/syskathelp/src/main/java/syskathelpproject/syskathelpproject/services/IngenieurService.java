package syskathelpproject.syskathelpproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import syskathelpproject.syskathelpproject.dao.IngenieurRepository;
//import syskathelpproject.syskathelpproject.dao.LogicielRepository;
import syskathelpproject.syskathelpproject.entities.Ingenieur;



@Service
@Transactional
public class IngenieurService {
	
	 @Autowired
	    private IngenieurRepository ingenieurrepository;
	 
	
	


	    public void saveLogiciel(Ingenieur ingenieur) {
	    	ingenieurrepository.save(ingenieur);
	    }
	    public void deleteingenieur(Ingenieur Ingenieur) {
	    	ingenieurrepository.delete(Ingenieur);
	    }

	   
	    public void deleteingenieur(Long idI) {
	    	ingenieurrepository.deleteById(idI);
	    }
	   

	    
	    public Ingenieur getIngenieurById(Long idI) {
	    	Optional<Ingenieur> optional = ingenieurrepository.findById(idI);
	    	Ingenieur Ingenieur = null;
	    	if(optional.isPresent()) {
	    		Ingenieur= optional.get();	    		
	    	}else {
	    		throw new RuntimeException("Ingenieur not found");
	    	}
	    	
	    	return Ingenieur;	
	    }
	    
	    public Page<Ingenieur> findPagination(int pageNo, int pagesize,String mc){
	    	
	    	Pageable pageable= PageRequest.of(pageNo - 1, pagesize);
	    	
	    	return this.ingenieurrepository.findAll(mc,pageable);
	    }
	    
	    
	  
	   
	    

}