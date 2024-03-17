package com.diegodesjardins.bank.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRequest {
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private Long countryId;

}
