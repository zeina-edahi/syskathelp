package com.example.transfer.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.transfer.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	
}
