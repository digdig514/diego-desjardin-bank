package com.diegodesjardins.bank.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

	private Long id;

	private String accountNumber;

	private BigDecimal balance;

	private ClientResponse client;

}
