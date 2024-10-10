package com.customer.points.rewards.exceptions;

public class ExcpetionResponse {
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
	public ExcpetionResponse(String errorMesg, String errorDescription) {
		super();
		this.errorMesg = errorMesg;
		this.errorDescription = errorDescription;
	}
	public ExcpetionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
