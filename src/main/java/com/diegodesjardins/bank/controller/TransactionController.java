package com.diegodesjardins.bank.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

import com.diegodesjardins.bank.dto.request.TransactionRequest;
import com.diegodesjardins.bank.dto.response.TransactionResponse;
import com.diegodesjardins.bank.model.Account;
import com.diegodesjardins.bank.model.Transaction;
import com.diegodesjardins.bank.service.TransactionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	TransactionService service;
	
	@GetMapping
	public ResponseEntity<List<TransactionResponse>> list() {

		List<TransactionResponse> response = service.findAll();
		return ResponseEntity.ok(response);

	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionResponse> findById(@PathVariable Long id) {

		TransactionResponse response = service.findById(id);
		return ResponseEntity.ok(response);

	}

	@PostMapping
	public ResponseEntity<TransactionResponse> create(@RequestBody TransactionRequest request) {
		TransactionResponse response = service.create(request);
		return ResponseEntity.ok(response);
	}

	

}
