package syskathelpproject.syskathelpproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import syskathelpproject.syskathelpproject.entities.Client;



public interface ClientRepository extends JpaRepository<Client,Long>{
    Page <Client > findAll(Pageable pageable);
public List<Client> findAll();
public void deleteById(Long idC);
@Query("select e from Client e where e.idC=:x")
public Client getOne(@Param("x")Long idC);
@Query("select e from Client e where e.idC=:x")
public Client getOnes(@Param("x")String nom);
	public Optional<Client> findById(Long idC);
	@Query("select e from Client e where e.nomsociete like :x OR e.nomcomplet like :x")
	public Page<Client> findAll(@Param("x")String mc,Pageable pageable);
	@Query("select e from Client e where e.nomcomplet like :x")
	public List<Client> chercher(@Param("x")String mc);
	@Query("select e from Client e where e.idC=:x")
	public Client getclientById(@Param("x")Long idC);
	@Query("select e from Client e where e.nomcomplet like :x")
	public Page<Client> cherchers(@Param("x")String mcs,Pageable pageable);
	@Query(value="select * from client e,client_logiciel c where e.idc = c.idc ",nativeQuery=true)
	public Optional<Client> clientlogiciel();
	@Query(value="SELECT count(c.idc) from client c ",nativeQuery=true)
	public long count();
	@Query("select e from Client e where e.nomsociete like :x OR e.nomcomplet like :x")
	public List<Client> chercherClients(@Param("x")String mc);
	
}
