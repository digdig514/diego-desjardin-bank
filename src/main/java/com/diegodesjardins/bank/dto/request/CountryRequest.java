package com.diegodesjardins.bank.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryRequest {

	private String name;

	private String coin;
}
