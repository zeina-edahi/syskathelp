package syskathelpproject.syskathelpproject.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import syskathelpproject.syskathelpproject.entities.logiciel;


public interface LogicielRepository extends JpaRepository<logiciel,Long>{
	
public List<logiciel> findAll();
Page <logiciel> findAll(Pageable pageable);
@Query("select e from logiciel e where e.nom=:x")
public logiciel getOne(@Param("x")String nom);
@Query("select e from logiciel e where e.nom=:x")
public logiciel getOnes(@Param("x")String nom);
	public List<logiciel> findById(long idL);
	@Query("select e from logiciel e where e.nom like :x")
	public Page<logiciel> findAll(@Param("x")String mc,Pageable pageable);
	@Query("select e from logiciel e where e.nom like :x")
	public List<logiciel> chercher(@Param("x")String mc);
	@Query("select e from logiciel e where e.idL=:x")
	public logiciel getlogicielById(@Param("x")Long ID);
	@Query("select e from logiciel e where e.nom like :x")
	public Page<logiciel> cherchers(@Param("x")String mcs,Pageable pageable);
	@Modifying
	@Transactional
	@Query(value="insert into client_logiciel (idc,idl) values (?,?)",nativeQuery=true)
	public void addlogicieltoclient(Long idc,Long idl);
	@Modifying
	@Transactional
	@Query(value="insert into ing_logiciel (idi,idl) values (?,?)",nativeQuery=true)
	public void addlogicieltoingenieur(Long idi,Long idl);
	@Query(value="select nom from logiciel e,client_logiciel c,client s where e.idl = c.idl AND c.idc=s.idc",nativeQuery=true)
	public List<String> nomlogicielclient();
	@Query(value="select version from logiciel e,client_logiciel c,client s where e.idl = c.idl AND c.idc=s.idc",nativeQuery=true)
	public List<String> versionlogicielclient();
	@Query(value="select tech from logiciel e,client_logiciel c,client s where e.idl = c.idl AND c.idc=s.idc",nativeQuery=true)
	public List<String> techlogicielclient();
	@Query(value="SELECT count(l.idl) from logiciel l",nativeQuery=true)
	public long count();
	
	@Query("select e from logiciel e where e.nom like :x")
	public Page<logiciel> chercherlogiciels(@Param("x")String mc,Pageable pageable);
	
	
}
