package com.diegodesjardins.bank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodesjardins.bank.dto.request.ClientRequest;
import com.diegodesjardins.bank.dto.response.ClientResponse;
import com.diegodesjardins.bank.model.Client;



@Component
public class ClientMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public ClientResponse response(Client model) {
		return mapper.map(model, ClientResponse.class);
	}

	public List<ClientResponse> response(List<Client> model) {
		return model.stream().map(m -> this.response(m)).collect(Collectors.toList());
	}
	
	public Client create(ClientRequest request) {
		return mapper.map(request, Client.class);
		
	}


}
