package com.diegodesjardins.bank.service;

import java.util.List;

import com.diegodesjardins.bank.dto.request.CountryRequest;
import com.diegodesjardins.bank.dto.response.CountryResponse;


public interface CountryService {
	List<CountryResponse> findAll();

	CountryResponse findById(Long id);

	CountryResponse create(CountryRequest request);

	CountryResponse update(Long id, CountryRequest request);

	void delete(Long id);

}
