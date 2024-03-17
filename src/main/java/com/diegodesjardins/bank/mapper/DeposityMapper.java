package com.diegodesjardins.bank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodesjardins.bank.dto.request.DeposityRequest;
import com.diegodesjardins.bank.dto.response.DeposityResponse;
import com.diegodesjardins.bank.model.Deposity;

@Component
public class DeposityMapper {

	@Autowired
	private ModelMapper mapper;
	
	public DeposityResponse response(Deposity model) {
		return mapper.map(model, DeposityResponse.class);
	}

	public List<DeposityResponse> response(List<Deposity> model) {
		return model.stream().map(m -> this.response(m)).collect(Collectors.toList());
	}
	
	public Deposity create(DeposityRequest request) {
		return mapper.map(request, Deposity.class);
		
	}

}
