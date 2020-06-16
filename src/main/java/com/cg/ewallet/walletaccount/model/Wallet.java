/****************************************************************************************************************************
 - File Name        : Wallet Class
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : This is Wallet class for wallet database model.
****************************************************************************************************************************/

package com.cg.ewallet.walletaccount.model;

public class Wallet {
	private long mobileNumber;
	private String name;
	private String email;
	private double balance;
	private String password;
	
/****************************************************************************************************************************	           
 - Description      : Generating Getters and Setters for the wallet database columns.
****************************************************************************************************************************/ 
	
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
