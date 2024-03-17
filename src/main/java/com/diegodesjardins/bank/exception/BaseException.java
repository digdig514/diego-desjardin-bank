package com.diegodesjardins.bank.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -4646029327778438637L;
	
	private HttpStatus status;
	
	private String message;
	

}
