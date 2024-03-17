package com.diegodesjardins.bank.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.diegodesjardins.bank.model.Client;

import jakarta.transaction.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	

	 @Query(value = "SELECT COALESCE(SUM(a.balance), 0) FROM client c JOIN account a ON c.id = a.owner_id WHERE c.id = :clientId", nativeQuery = true)
	    BigDecimal calculateClientBalanceNativeQuery(Long clientId);


	 
	
	 
}
