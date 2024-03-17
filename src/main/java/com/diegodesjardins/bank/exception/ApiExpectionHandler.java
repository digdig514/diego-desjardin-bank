package com.diegodesjardins.bank.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExpectionHandler {
	
	@ExceptionHandler(BaseException.class)
	public ResponseEntity<Object> handlerBaseExpection( BaseException ex, WebRequest request){
	
		ProblemDetail problemDetail =  ProblemDetail.forStatusAndDetail(ex.getStatus(), ex.getMessage());
		
		return ResponseEntity.status(ex.getStatus()).body(problemDetail);

	}

}
