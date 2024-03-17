package com.diegodesjardins.bank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodesjardins.bank.dto.request.CountryRequest;
import com.diegodesjardins.bank.dto.response.CountryResponse;
import com.diegodesjardins.bank.model.Country;

@Component
public class CountryMapper {

	@Autowired
	private ModelMapper mapper;
	
	public CountryResponse response(Country model) {
		return mapper.map(model, CountryResponse.class);
	}

	public List<CountryResponse> response(List<Country> model) {
		return model.stream().map(m -> this.response(m)).collect(Collectors.toList());
	}
	
	public Country create(CountryRequest request) {
		return mapper.map(request, Country.class);
		
	}

}
