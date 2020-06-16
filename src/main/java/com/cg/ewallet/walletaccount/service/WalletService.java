/************************************************************************************************************************************
 - File Name        : WalletService Interface
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : This is an service interface where all the controller class methods defines.
**************************************************************************************************************************************/
package com.cg.ewallet.walletaccount.service;

import java.util.List;

import com.cg.ewallet.walletaccount.dto.WalletEntity;
import com.cg.ewallet.walletaccount.exception.WalletExistException;
import com.cg.ewallet.walletaccount.exception.WalletNotFoundException;
import com.cg.ewallet.walletaccount.model.Wallet;

public interface WalletService {

	public List<Wallet> viewWallet();
	public WalletEntity getWalletByMobileNumber(long mobileNumber) throws WalletNotFoundException;	
	public String addWallet(WalletEntity wallet) throws WalletExistException;
	public String updateWallet(long mobileNumber, WalletEntity wallet) throws WalletNotFoundException;
	public String deleteWallet(long mobileNumber) throws WalletNotFoundException;


}
