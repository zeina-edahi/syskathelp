package syskathelpproject.syskathelpproject.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import syskathelpproject.syskathelpproject.entities.Admin;


public interface AdminRepository extends JpaRepository<Admin,String>{
	

@Query("select e from Admin e where e.username=:x")
public Admin getOne(@Param("x")String ID);


}
