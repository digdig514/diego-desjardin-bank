package com.diegodesjardins.bank.service;

import java.util.List;

import com.diegodesjardins.bank.dto.request.ClientRequest;
import com.diegodesjardins.bank.dto.response.ClientResponse;

public interface ClientService {

	List<ClientResponse> findAll();

	ClientResponse findById(Long id);

	ClientResponse create(ClientRequest request);

	ClientResponse update(Long id, ClientRequest request);

	void delete(Long id);

}
