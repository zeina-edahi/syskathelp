package syskathelpproject.syskathelpproject.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import syskathelpproject.syskathelpproject.entities.logiciel;


public interface LogicielRepository extends JpaRepository<logiciel,Long>{
	
public List<logiciel> findAll();

@Query("select e from logiciel e where e.nom=:x")
public logiciel getOne(@Param("x")String nom);
@Query("select e from logiciel e where e.nom=:x")
public logiciel getOnes(@Param("x")String nom);
	public List<logiciel> findById(long ID);
	@Query("select e from logiciel e where e.nom like :x")
	public Page<logiciel> chercherlogiciels(@Param("x")String mc,Pageable pageable);
	@Query("select e from logiciel e where e.nom like :x")
	public List<logiciel> chercher(@Param("x")String mc);
	
}
