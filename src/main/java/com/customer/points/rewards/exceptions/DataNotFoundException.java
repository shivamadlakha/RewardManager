package com.customer.points.rewards.exceptions;

public class DataNotFoundException extends RuntimeException{
	private String errorMesg;
	private String errorDescription;
	public String getErrorMesg() {
		return errorMesg;
	}
	public void setErrorMesg(String errorMesg) {
		this.errorMesg = errorMesg;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public DataNotFoundException(String errorMesg, String errorDescription) {
		super();
		this.errorMesg = errorMesg;
		this.errorDescription = errorDescription;
	}
}
