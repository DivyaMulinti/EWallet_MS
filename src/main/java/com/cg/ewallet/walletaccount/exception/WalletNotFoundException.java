/****************************************************************************************************************************
 - File Name        : WalletNotFoundException Class
 - Author           : Divya Mulinti
 - Creation Date    : 12-06-2020
 - Description      : This class will extends Exception class.
****************************************************************************************************************************/

package com.cg.ewallet.walletaccount.exception;

 public class WalletNotFoundException extends Exception{
	 private static final long serialVersionUID = 1L;
		final String msg;
		public WalletNotFoundException(String msg) {
			super();
			this.msg= msg;
		}	
		
		@Override
		public String getMessage() {
			return msg;
		}
 }
