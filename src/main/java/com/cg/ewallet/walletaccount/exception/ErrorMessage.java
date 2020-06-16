/****************************************************************************************************************************
 - File Name        : ErrorMessage Class
 - Author           : Divya Mulinti
 - Creation Date    : 12-06-2020
 - Description      : This is an Error message which handles the exception for wallet.
****************************************************************************************************************************/
package com.cg.ewallet.walletaccount.exception;

public class ErrorMessage {
	private int statusCode;
	private String errorMessage;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
