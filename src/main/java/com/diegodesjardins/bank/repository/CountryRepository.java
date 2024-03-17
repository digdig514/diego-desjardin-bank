package com.diegodesjardins.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegodesjardins.bank.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
