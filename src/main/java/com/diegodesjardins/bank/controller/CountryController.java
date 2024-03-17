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

import com.diegodesjardins.bank.dto.request.CountryRequest;
import com.diegodesjardins.bank.dto.response.CountryResponse;
import com.diegodesjardins.bank.service.CountryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {

	CountryService service;

	@GetMapping
	public ResponseEntity<List<CountryResponse>> list() {

		List<CountryResponse> response = service.findAll();
		return ResponseEntity.ok(response);

	}

	@GetMapping("/{id}")
	public ResponseEntity<CountryResponse> findById(@PathVariable Long id) {

		CountryResponse response = service.findById(id);
		return ResponseEntity.ok(response);

	}

	@PostMapping
	public ResponseEntity<CountryResponse> create(@RequestBody CountryRequest request) {
		CountryResponse response = service.create(request);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CountryResponse> update(@PathVariable Long id, @RequestBody CountryRequest request) {

		CountryResponse response = service.update(id, request);

		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
