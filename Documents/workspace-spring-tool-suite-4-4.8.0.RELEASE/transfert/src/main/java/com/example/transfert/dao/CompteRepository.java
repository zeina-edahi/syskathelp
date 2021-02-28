package com.example.transfert.dao;







import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.transfert.entities.Client;
import com.example.transfert.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte,String> {
	
	@Query("select e from Compte e where e.num=:x")
	public Compte getOne(@Param("x")String id);
	public List<Compte> findAll();
	//public page<Compte> findAll();
	public Page<Compte> findByNum(String num,Pageable pageable);
	@Modifying  @Transactional @Query(value="delete c from Compte c where c.idc=:x" ,nativeQuery=true)
public void deleteById(@Param("x")long id)	;
	
	@Modifying  @Transactional @Query(value="update Compte c set c.montant=c.montant+:y where c.num like :x " ,nativeQuery=true) 
	public void versser (@Param("x")String num ,@Param("y") long montant);
	@Modifying  @Transactional @Query(value=" update Compte c set c.montant=c.montant-:y where c.num like :x " ,nativeQuery=true) 
	public void retirer(@Param("x")String compte1,@Param("y")long montant);
	
	  @Transactional @Query(value="select e from Compte e where e.num like :x" ,nativeQuery=true)
	public Page<Compte> chercherCompte(@Param("x")String mc,Pageable pageable);
	
	
	
	

}
