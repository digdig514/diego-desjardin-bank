package com.diegodesjardins.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.diegodesjardins.bank.dto.request.AccountRequest;
import com.diegodesjardins.bank.dto.response.AccountResponse;
import com.diegodesjardins.bank.exception.BaseException;
import com.diegodesjardins.bank.mapper.AccountMapper;
import com.diegodesjardins.bank.model.Account;
import com.diegodesjardins.bank.model.Client;
import com.diegodesjardins.bank.repository.AccountRepository;
import com.diegodesjardins.bank.repository.ClientRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl  implements AccountService{
	
private AccountRepository repository;
	
	private AccountMapper mapper;
	
	private ClientRepository clientRepository;

	@Transactional
	@Override
	public AccountResponse create(AccountRequest request) {
		Account model = mapper.create(request);
		Optional<Client> client = clientRepository.findById(request.getClientId());
		if(client.isEmpty()) {
			
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Client not found with Id: %d  ", request.getClientId()));
		}
		model.setClient(client.get());
		model = repository.save(model);
		return mapper.response(model);
	}


	@Override
	public AccountResponse findById(Long id) {
		
		Optional<Account> model = repository.findById(id);
		 if (model.isEmpty()) {
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Client not found with Id: %d  ", id));
		 }
		
		return mapper.response(model.get());
		
	}

	@Transactional
	@Override
	public AccountResponse update(Long id, AccountRequest request) {
		
		Optional<Account> model =  repository.findById(id);
		 if (model.isEmpty()) {
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Account not found with Id: %d  ", id));
		 }
		BeanUtils.copyProperties(request, model.get());
		repository.save(model.get());
		return mapper.response(model.get());
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Account> model =  repository.findById(id);
		 if (model.isEmpty()) {
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Account not found with Id: %d  ", id));
		 }
		repository.delete(model.get());
		
		
	}
}
