package com.diegodesjardins.bank.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionRequest {
	
	private String sourceAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal amount;
    private String description;

}
