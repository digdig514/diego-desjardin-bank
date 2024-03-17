package com.diegodesjardins.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.diegodesjardins.bank.dto.request.CountryRequest;
import com.diegodesjardins.bank.dto.response.CountryResponse;
import com.diegodesjardins.bank.exception.BaseException;
import com.diegodesjardins.bank.mapper.CountryMapper;
import com.diegodesjardins.bank.model.Client;
import com.diegodesjardins.bank.model.Country;
import com.diegodesjardins.bank.repository.CountryRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CountryServiceImpl implements CountryService{
	
private CountryRepository repository;
	
	private CountryMapper mapper;

	@Transactional
	@Override
	public CountryResponse create(CountryRequest request) {
		Country model = mapper.create(request);
		model = repository.save(model);
		return mapper.response(model);
	}

	@Override
	public List<CountryResponse> findAll() {
		List<Country> model = repository.findAll();
		return mapper.response(model);
 	}

	@Override
	public CountryResponse findById(Long id) {
		
		Optional<Country> model = repository.findById(id);
		 if (model.isEmpty()) {
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Country not found with Id: %d  ", id));
		 }
		
		return mapper.response(model.get());
		
	}

	@Transactional
	@Override
	public CountryResponse update(Long id, CountryRequest request) {
		
		Optional<Country> model =  repository.findById(id);
		 if (model.isEmpty()) {
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Country not found with Id: %d  ", id));
		 }
		BeanUtils.copyProperties(request, model.get());
		repository.save(model.get());
		return mapper.response(model.get());
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Country> model =  repository.findById(id);
		 if (model.isEmpty()) {
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Country not found with Id: %d  ", id));
		 }
		repository.delete(model.get());
		
		
	}

}
