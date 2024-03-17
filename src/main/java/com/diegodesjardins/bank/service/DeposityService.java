package com.diegodesjardins.bank.service;

import java.util.List;

import com.diegodesjardins.bank.dto.request.DeposityRequest;
import com.diegodesjardins.bank.dto.response.DeposityResponse;

public interface DeposityService {
	

	List<DeposityResponse> findAllByAccount(String account);
	
	DeposityResponse findById(Long id);

	DeposityResponse create(DeposityRequest request);

	DeposityResponse update(Long id, DeposityRequest request);

	void delete(Long id);


	


}
