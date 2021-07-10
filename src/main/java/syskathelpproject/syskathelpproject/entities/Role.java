
package syskathelpproject.syskathelpproject.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class Role {

@Id    

@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
     private String role;
     
     @ManyToMany(mappedBy = "roles")
     private Set<Users> users;
     
     public Long getId() {
         return id;
     }

     public void setId(Long id) {
    	 
    	    this.id = id;
     
     }
	public Role( String role) {
		super();
	
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public Role() {
		super();
	}


	 public Set<Users> getUsers() {
	        return users;
	    }

	    public void setUsers(Set<Users> users) {
	        this.users = users;
	    }
    
    }