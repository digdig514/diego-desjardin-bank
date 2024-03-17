package com.diegodesjardins.bank.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeposityResponse {

	private Long id;

	private AccountResponse destinationAccount;

	private BigDecimal amount;

	private LocalDateTime date;

	private String description;
}
