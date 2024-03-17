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

import com.diegodesjardins.bank.dto.request.DeposityRequest;
import com.diegodesjardins.bank.dto.response.DeposityResponse;
import com.diegodesjardins.bank.service.DeposityService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deposity")
public class DepositController {
	
	DeposityService service;


	@GetMapping("/{id}")
	public ResponseEntity<DeposityResponse> findById(@PathVariable Long id) {

		DeposityResponse response = service.findById(id);
		return ResponseEntity.ok(response);

	}

	@PostMapping
	public ResponseEntity<DeposityResponse> create(@RequestBody DeposityRequest request) {
		DeposityResponse response = service.create(request);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DeposityResponse> update(@PathVariable Long id, @RequestBody DeposityRequest request) {

		DeposityResponse response = service.update(id, request);

		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}
