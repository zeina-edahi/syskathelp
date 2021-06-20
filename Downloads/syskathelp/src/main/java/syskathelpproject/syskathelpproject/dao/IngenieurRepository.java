package syskathelpproject.syskathelpproject.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syskathelpproject.syskathelpproject.entities.Ingenieur;


public interface IngenieurRepository extends JpaRepository<Ingenieur,Long>{
	
public List<Ingenieur> findAll();

@Query("select e from Ingenieur e where e.nom=:x")
public Ingenieur getOne(@Param("x")String nom);
@Query("select e from Ingenieur e where e.nom=:x")
public Ingenieur getOnes(@Param("x")String nom);
	public List<Ingenieur> findById(long ID);
	@Query("select e from Ingenieur e where e.nom like :x")
	public Page<Ingenieur> chercherIngenieurs(@Param("x")String mc,Pageable pageable);
	@Query("select e from Ingenieur e where e.nom like :x")
	public List<Ingenieur> chercher(@Param("x")String mc);
	
	
}
