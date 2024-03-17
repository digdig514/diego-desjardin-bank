package com.diegodesjardins.bank.service;

import java.util.List;

import com.diegodesjardins.bank.dto.request.TransactionRequest;
import com.diegodesjardins.bank.dto.response.TransactionResponse;

public interface TransactionService {
	
	List<TransactionResponse> findAll();

	TransactionResponse findById(Long id);

	TransactionResponse create(TransactionRequest request);

}
