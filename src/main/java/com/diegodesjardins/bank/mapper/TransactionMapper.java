package com.diegodesjardins.bank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodesjardins.bank.dto.request.TransactionRequest;
import com.diegodesjardins.bank.dto.response.TransactionResponse;
import com.diegodesjardins.bank.model.Transaction;

@Component
public class TransactionMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public TransactionResponse response(Transaction model) {
		return mapper.map(model, TransactionResponse.class);
	}

	public List<TransactionResponse> response(List<Transaction> model) {
		return model.stream().map(m -> this.response(m)).collect(Collectors.toList());
	}
	
	public Transaction create(TransactionRequest request) {
		return mapper.map(request, Transaction.class);
		
	}

}
