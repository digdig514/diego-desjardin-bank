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

import com.diegodesjardins.bank.dto.request.ClientRequest;
import com.diegodesjardins.bank.dto.response.ClientResponse;
import com.diegodesjardins.bank.model.Client;
import com.diegodesjardins.bank.service.ClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

	private ClientService service;

	@GetMapping
	public ResponseEntity<List<ClientResponse>> list() {

		List<ClientResponse> response = service.findAll();
		return ResponseEntity.ok(response);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientResponse> findById(@PathVariable Long id) {

		ClientResponse response = service.findById(id);
		return ResponseEntity.ok(response);

	}

	@PostMapping
	public ResponseEntity<ClientResponse> create(@RequestBody ClientRequest request) {
		ClientResponse response = service.create(request);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientResponse> update(@PathVariable Long id, @RequestBody ClientRequest request) {

		ClientResponse response = service.update(id, request);

		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}