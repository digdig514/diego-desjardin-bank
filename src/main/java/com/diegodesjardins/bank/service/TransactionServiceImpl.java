package com.diegodesjardins.bank.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.diegodesjardins.bank.dto.request.TransactionRequest;
import com.diegodesjardins.bank.dto.response.TransactionResponse;
import com.diegodesjardins.bank.exception.BaseException;
import com.diegodesjardins.bank.mapper.TransactionMapper;
import com.diegodesjardins.bank.model.Account;
import com.diegodesjardins.bank.model.Transaction;
import com.diegodesjardins.bank.repository.AccountRepository;
import com.diegodesjardins.bank.repository.TransactionRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

	private TransactionRepository repository;
	
	private AccountRepository accountRepository;

	private TransactionMapper mapper;

	@Transactional
	@Override
	public TransactionResponse create(TransactionRequest request) {
		Transaction model = mapper.create(request);
		Optional<Account> sourceAccount = accountRepository.findByAccountNumber(request.getSourceAccountNumber());
		if (sourceAccount.isEmpty()) {
			throw new BaseException(HttpStatus.NOT_FOUND, "Account NotFound");
		}
		model.setSourceAccount(sourceAccount.get());
		Optional<Account> destinationAccountId = accountRepository.findByAccountNumber(request.getDestinationAccountNumber());
		if (destinationAccountId.isEmpty()) {
			throw new BaseException(HttpStatus.NOT_FOUND, "Account NotFound");
		}
		model.setDate(LocalDateTime.now());
		model.setDestinationAccount(destinationAccountId.get());
		model = repository.save(model);
		return mapper.response(model);
	}

	@Override
	public List<TransactionResponse> findAll() {
		List<Transaction> model = repository.findAll();
		return mapper.response(model);
	}

	@Override
	public TransactionResponse findById(Long id) {

		Optional<Transaction> model = repository.findById(id);
		if (model.isEmpty()) {
			throw new BaseException(HttpStatus.NOT_FOUND, String.format("Transaction not found with Id: %d  ", id));
		}

		return mapper.response(model.get());

	}

	
}
