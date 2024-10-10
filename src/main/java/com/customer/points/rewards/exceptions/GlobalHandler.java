package com.customer.points.rewards.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ExcpetionResponse> handleDataNotFound(DataNotFoundException ex){
		String msg=ex.getErrorMesg();
		String desc=ex.getErrorDescription();
		ExcpetionResponse eResponse=new ExcpetionResponse(msg,desc);
		return new ResponseEntity<>(eResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExcpetionResponse> handleOtherException(Exception ex){
		String msg=ex.getMessage();
		String desc=ex.getLocalizedMessage();
		ExcpetionResponse eResponse=new ExcpetionResponse(msg,desc);
		return new ResponseEntity<>(eResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
