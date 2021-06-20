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
	
public List<Client> findAll();
public void deleteById(Long ID);
@Query("select e from Client e where e.idC=:x")
public Client getOne(@Param("x")Long ID);
@Query("select e from Client e where e.idC=:x")
public Client getOnes(@Param("x")String nom);
	public Optional<Client> findById(Long ID);
	@Query("select e from Client e where e.nom like :x")
	public Page<Client> chercherClients(@Param("x")String mc,Pageable pageable);
	@Query("select e from Client e where e.nom like :x")
	public List<Client> chercher(@Param("x")String mc);
	@Query("select e from Client e where e.idC=:x")
	public Client getclientById(@Param("x")Long ID);
	
	
}
