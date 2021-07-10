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

Page <Ingenieur> findAll(Pageable pageable);

@Query("select e from Ingenieur e where e.noming=:x")
public Ingenieur getOne(@Param("x")String noming);

@Query("select e from Ingenieur e where e.noming=:x")
public Ingenieur getOnes(@Param("x")String noming);

	public List<Ingenieur> findById(long idI);
	
	@Query("select e from Ingenieur e where e.noming like :x")
	public Page<Ingenieur> findAll(@Param("x")String mc,Pageable pageable);
	
	@Query("select e from Ingenieur e where e.noming like :x")
	public List<Ingenieur> chercher(@Param("x")String mc);
	
	@Query("select e from Ingenieur e where e.idI=:x")
	public Ingenieur getIngenieurById(@Param("x")Long idI);
	

	
	@Query("select e from Ingenieur e where e.noming like :x")
	public Page<Ingenieur> cherchers(@Param("x")String mcs,Pageable pageable);
	
	@Query(value="SELECT count(i.idi) from ingenieur i ",nativeQuery=true)
	public long count();
}
