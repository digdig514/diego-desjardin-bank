package com.diegodesjardins.bank.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.diegodesjardins.bank.dto.request.DeposityRequest;
import com.diegodesjardins.bank.dto.response.DeposityResponse;
import com.diegodesjardins.bank.exception.BaseException;
import com.diegodesjardins.bank.mapper.DeposityMapper;
import com.diegodesjardins.bank.model.Account;
import com.diegodesjardins.bank.model.Deposity;
import com.diegodesjardins.bank.repository.AccountRepository;
import com.diegodesjardins.bank.repository.DeposityRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeposityServiceImpl implements DeposityService {

	private DeposityRepository repository;

	private DeposityMapper mapper;

	private AccountRepository accountRepository;

	@Transactional
	@Override
	public DeposityResponse create(DeposityRequest request) {
		Deposity model = mapper.create(request);
		Optional<Account> account = accountRepository.findByAccountNumber(request.getDestinationAccount());
		if (account.isEmpty()) {
			throw new BaseException(HttpStatus.NOT_FOUND,
					String.format("Account not found with account: %d  ", request.getDestinationAccount()));
		}
		model.setDate(LocalDateTime.now());
		model.setDestinationAccount(account.get());
		model = repository.save(model);
		return mapper.response(model);
	}

	@Override
	public DeposityResponse findById(Long id) {

		Optional<Deposity> model = repository.findById(id);
		if (model.isEmpty()) {
			throw new BaseException(HttpStatus.NOT_FOUND, String.format("Deposity not found with Id: %d  ", id));
		}

		return mapper.response(model.get());

	}

	@Transactional
	@Override
	public DeposityResponse update(Long id, DeposityRequest request) {

		Optional<Deposity> model = repository.findById(id);
		if (model.isEmpty()) {
			throw new BaseException(HttpStatus.NOT_FOUND, String.format("Deposity not found with Id: %d  ", id));
		}
		BeanUtils.copyProperties(request, model.get());
		repository.save(model.get());
		return mapper.response(model.get());
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Deposity> model = repository.findById(id);
		if (model.isEmpty()) {
			throw new BaseException(HttpStatus.NOT_FOUND, String.format("Deposity not found with Id: %d  ", id));
		}
		repository.delete(model.get());

	}

	@Override
	public List<DeposityResponse> findAllByAccount(String account) {
		List<Deposity> model = repository.findAllByDestinationAccountAccountNumber(account);

		return mapper.response(model);
	}

}
