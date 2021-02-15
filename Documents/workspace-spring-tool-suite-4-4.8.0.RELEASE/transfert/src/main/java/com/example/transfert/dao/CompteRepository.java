package com.example.transfert.dao;







import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.transfert.entities.Client;
import com.example.transfert.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte,String> {
	
	
	//public void virement (String num1 , String num2);
	public List<Compte> findAll();
	public Page<Compte> findByNum(String num,Pageable pageable);
	@Query("update Compte c set c.montant=c.montant+:y where c.num like :x ")
	@Modifying(clearAutomatically = true)
	public void versser (@Param("x")String num ,@Param("y") long montant);
	@Query("update Compte c set c.montant=c.montant-:y where c.num like :x ")
	@Modifying(clearAutomatically = true)
	public void retirer (@Param("x")String num ,@Param("y") long montant);
	@Query("select e from Compte e where e.num like :x ")
	public Page<Compte> chercherCompte(@Param("x")String mc,Pageable pageable);
}
