package com.diegodesjardins.bank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodesjardins.bank.dto.request.AccountRequest;
import com.diegodesjardins.bank.dto.response.AccountResponse;
import com.diegodesjardins.bank.dto.response.DeposityResponse;
import com.diegodesjardins.bank.service.AccountService;
import com.diegodesjardins.bank.service.DeposityService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

	private AccountService service;

	private DeposityService deposityService;

	@GetMapping("/{id}")
	public ResponseEntity<AccountResponse> findById(@PathVariable Long id) {

		AccountResponse response = service.findById(id);
		return ResponseEntity.ok(response);

	}

	@PostMapping
	public ResponseEntity<AccountResponse> create(@RequestBody AccountRequest request) {
		AccountResponse response = service.create(request);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AccountResponse> update(@PathVariable Long id, @RequestBody AccountRequest request) {

		AccountResponse response = service.update(id, request);

		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{account}/deposit")
	public ResponseEntity<List<DeposityResponse>> listDeposityByAccount(@PathVariable String account) {

		List<DeposityResponse> response = deposityService.findAllByAccount(account);
		return ResponseEntity.ok(response);

	}

}
