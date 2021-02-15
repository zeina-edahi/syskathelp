package com.example.transfert.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.transfert.entities.Client;



public interface ClientRepository extends JpaRepository<Client,Long>{
	
	public List<Client> findAll();
	public void deleteById(long id);
//	public Client getOne(long id);
@Query("select e from Client e where e.id=:x")
 public Client getOne(@Param("x")long id);
	
	public Client findById(long id);
	//public Page<Client> findById(long id,Pageable pageable);
	@Query("select e from Client e where e.nom like :x")
	public Page<Client> chercherClients(@Param("x")String mc,Pageable pageable);
	
}