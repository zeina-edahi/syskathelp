package syskathelpproject.syskathelpproject.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syskathelpproject.syskathelpproject.entities.Ticket;



public interface TicketRepository extends JpaRepository<Ticket,Long>{
    Page <Ticket> findAll(Pageable pageable);
public List<Ticket> findAll();
public void deleteById(Long idT);

@Query("select e from Ticket e where e.idT=:x")
public Ticket getOne(@Param("x")Long idT);

	
	@Query("select e from Ticket e where e.client.nomsociete like :x")
	public Page<Ticket> findAll(@Param("x")String mc,Pageable pageable);
	

	
	@Query("select e from Ticket e where e.idT=:x")
	public 	Ticket getTicketById(@Param("x")Long idT);
	
	
	@Query(value="SELECT count(t.idT) from ticket t where t.etat like :x",nativeQuery=true)
	public long count(@Param("x")String etat);
	
}
