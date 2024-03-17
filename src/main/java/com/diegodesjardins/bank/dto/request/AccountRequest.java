package com.diegodesjardins.bank.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountRequest {

	private String accountNumber;

	private Long clientId;

}
