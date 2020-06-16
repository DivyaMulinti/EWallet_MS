/****************************************************************************************************************************
 - File Name        : WalletEntity Class
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : This is an entity class for wallet.
****************************************************************************************************************************/ 
package com.cg.ewallet.walletaccount.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="wallet")
public class WalletEntity {
	@Id
	@Column(name="mobilenumber")
//	@NotBlank(message = "Mobile number is mandatory")
	//@Pattern(regexp ="^[1-9]{1}[0-9]{9}$", message = "Mobile number can only be in numbers and length should be 10 digits only.")
	private long mobileNumber;
	
	@Column(name="name")
	@NotBlank(message = "Name is mandatory")
	@NotNull(message = "Name is mandatory")
	@Size(min=3,max=16, message= "Name length should be between 3 to 16")
	@Pattern(regexp ="^[A-Za-z]*", message = "Name can only be in alphabets.")
	private String name;
	
	@Email
	@Column(name="email")
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotNull(message = "Balance is mandatory")
	@Range(min = 1000, max = 10000000, message = "Balance should be 1000 to 10000000!")
	@Column(name="balance")
	private double balance;
	
	@Column(name="password")
	@NotBlank(message = "password is mandatory")
	@NotNull(message = "password is mandatory")
	@Pattern(regexp ="((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})", message = "Password should contain at least one lowercase letter, at least one digit i.e. 0-9, at least one special character, at least one capital letter and length should be min 6 to max 16 letters")
	private String password;

/****************************************************************************************************************************	           
- Description      : Generating constructor for WalletEntity class.
****************************************************************************************************************************/
	public WalletEntity(long mobileNumber, String name, String email, double balance, String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.password = password;
	}
	
	public WalletEntity() {
		super();
	}
	
	
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
