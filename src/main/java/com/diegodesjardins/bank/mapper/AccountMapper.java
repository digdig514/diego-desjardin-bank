package com.diegodesjardins.bank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodesjardins.bank.dto.request.AccountRequest;
import com.diegodesjardins.bank.dto.response.AccountResponse;
import com.diegodesjardins.bank.model.Account;

@Component
public class AccountMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public AccountResponse response(Account model) {
		return mapper.map(model, AccountResponse.class);
	}

	public List<AccountResponse> response(List<Account> model) {
		return model.stream().map(m -> this.response(m)).collect(Collectors.toList());
	}
	
	public Account create(AccountRequest request) {
		return mapper.map(request, Account.class);
		
	}

}
