package com.diegodesjardins.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.diegodesjardins.bank.dto.request.ClientRequest;
import com.diegodesjardins.bank.dto.response.ClientResponse;
import com.diegodesjardins.bank.exception.BaseException;
import com.diegodesjardins.bank.mapper.ClientMapper;
import com.diegodesjardins.bank.model.Client;
import com.diegodesjardins.bank.model.Country;
import com.diegodesjardins.bank.repository.ClientRepository;
import com.diegodesjardins.bank.repository.CountryRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService{
	
	private ClientRepository repository;
	
	private ClientMapper mapper;
	
	private CountryRepository countryRepository;

	@Transactional
	@Override
	public ClientResponse create(ClientRequest request) {
		Client model = mapper.create(request);
		Optional<Country> country = countryRepository.findById(request.getCountryId());
		if (country.isEmpty()) {
			throw new BaseException(HttpStatus.NOT_FOUND, "Account NotFound");
		}
		model.setCountry(country.get());
		model = repository.save(model);
		return mapper.response(model);
	}

	@Override
	public List<ClientResponse> findAll() {
		List<Client> model = repository.findAll();
		return mapper.response(model);
 	}

	@Override
	public ClientResponse findById(Long id) {
		
		Optional<Client> model = repository.findById(id);
		 if (model.isEmpty()) {
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Client not found with Id: %d  ", id));
		 }
		
		return mapper.response(model.get());
		
	}

	@Transactional
	@Override
	public ClientResponse update(Long id, ClientRequest request) {
		
		Optional<Client> model =  repository.findById(id);
		 if (model.isEmpty()) {
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Client not found with Id: %d  ", id));
		 }
		BeanUtils.copyProperties(request, model.get());
		repository.save(model.get());
		return mapper.response(model.get());
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Client> model =  repository.findById(id);
		 if (model.isEmpty()) {
			 throw new BaseException(HttpStatus.NOT_FOUND , String.format("Client not found with Id: %d  ", id));
		 }
		repository.delete(model.get());
		
		
	}
	
	

}
