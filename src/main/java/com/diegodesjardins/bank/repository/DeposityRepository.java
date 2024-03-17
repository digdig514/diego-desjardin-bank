package com.diegodesjardins.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegodesjardins.bank.model.Deposity;

@Repository
public interface DeposityRepository  extends JpaRepository<Deposity, Long> {
	

	List<Deposity> findAllByDestinationAccountAccountNumber(String account); 

}
