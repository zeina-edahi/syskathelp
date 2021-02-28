package com.example.transfert.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.transfert.entities.Client;
import com.example.transfert.entities.Compte;



public interface ClientRepository extends JpaRepository<Client,Long>{
	
public List<Client> findAll();
	public void deleteById(long id);
@Query("select e from Client e where e.id=:x")
public Client getOne(@Param("x")long id);
@Query("select e from Client e where e.nom=:x")
public Client getOnes(@Param("x")String nom);
	public List<Client> findById(long id);
	public Page<Client> findById(long id,Pageable pageable);
	@Query("select c from Compte c where c.client.id like :x")
	public List<Compte> getCompteByClient(@Param("x")Long id);
	@Query("select e from Client e where e.nom like :x")
	public Page<Client> chercherClients(@Param("x")String mc,Pageable pageable);
	@Query("select e from Client e where e.nom like :x")
	public List<Client> chercher(@Param("x")String mc);
	
}