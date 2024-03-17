package com.diegodesjardins.bank.dto.response;

import com.diegodesjardins.bank.model.Country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
	
	private Long id;
	
    private String name;
    
    private String email;
    
    private Country country;
    

}
