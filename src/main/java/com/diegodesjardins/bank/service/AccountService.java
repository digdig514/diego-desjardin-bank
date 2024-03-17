package com.diegodesjardins.bank.service;

import java.util.List;

import com.diegodesjardins.bank.dto.request.AccountRequest;
import com.diegodesjardins.bank.dto.response.AccountResponse;
import com.diegodesjardins.bank.dto.response.DeposityResponse;

public interface AccountService {
	

	AccountResponse findById(Long id);

	AccountResponse create(AccountRequest request);

	AccountResponse update(Long id, AccountRequest request);

	void delete(Long id);


}
