package syskathelpproject.syskathelpproject.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syskathelpproject.syskathelpproject.dao.AdminRepository;
import syskathelpproject.syskathelpproject.entities.Admin;

@Service
@Transactional
public class AdminService {
	 @Autowired
	    private AdminRepository adminrepository;

    public Admin getCustomer(String username) {
        return adminrepository.getById(username); 
    }

}
