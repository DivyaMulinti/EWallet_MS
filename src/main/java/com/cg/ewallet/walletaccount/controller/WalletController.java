/****************************************************************************************************************************
 - File Name        : WalletController Class
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : This is an end point controller for wallet.
****************************************************************************************************************************/ 
package com.cg.ewallet.walletaccount.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ewallet.walletaccount.dto.WalletEntity;
import com.cg.ewallet.walletaccount.exception.WalletExistException;
import com.cg.ewallet.walletaccount.exception.WalletNotFoundException;
import com.cg.ewallet.walletaccount.model.Wallet;
import com.cg.ewallet.walletaccount.service.WalletService;

@RestController
@RequestMapping("/wallet")

public class WalletController {
	@Autowired
	WalletService service;
	
/****************************************************************************************************************************
 - Method Name      : viewWallet
 - Return type      : List<Wallet>
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : Fetching all wallets information from wallet database.
****************************************************************************************************************************/ 	

	
	    @GetMapping("/viewWallets")
	    public  List<Wallet> viewWallet() {
		    return service.viewWallet();
	    }
	    
/****************************************************************************************************************************
 - Method Name      : getWalletByMobileNumber
 - Input Parameters : mobileNumber
 - Return type      : ResponseEntity<WalletEntity>
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : Fetching the wallet information from wallet database by mobileNumber.
****************************************************************************************************************************/ 		    
	    
        // http://localhost:9092/wallet/viewWallet/8008020917
		@RequestMapping(value = "/viewWallet/{mobileNumber}", method = RequestMethod.GET)
		public ResponseEntity<WalletEntity> getWalletByMobileNumber(@PathVariable("mobileNumber") long mobileNumber) throws WalletNotFoundException {
			WalletEntity wallet = service.getWalletByMobileNumber(mobileNumber);
			return new ResponseEntity<>(wallet,HttpStatus.OK);
		}
		
/****************************************************************************************************************************
 - Method Name      : addWallet
 - Input Parameters : wallet
 - Return type      : ResponseEntity<String>
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : Inserting the wallet information into wallet database.		
****************************************************************************************************************************/ 	
				
		// http://localhost:9092/wallet/addwallet
		@RequestMapping(value = "/addwallet", method = RequestMethod.POST)
		public ResponseEntity<String> addWallet(@Valid @RequestBody WalletEntity wallet) throws WalletExistException {
			String msg= service.addWallet(wallet);
			return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);

		}

/****************************************************************************************************************************
 - Method Name      : updateStatusByMobileNumber 
 - Return type      : ResponseEntity<String>
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : Updating all pending wallet status.
****************************************************************************************************************************/ 	
		
		//http://localhost:9092/wallet/updatewallet/8008020917
		@RequestMapping(value ="/updatewallet/{mobileNumber}", method = RequestMethod.PUT)
		public ResponseEntity<String> updateStatusByMobileNumber(@PathVariable("mobileNumber") long mobileNumber,
				@RequestBody WalletEntity wallet) throws WalletNotFoundException {
			String msg= service.updateWallet(mobileNumber, wallet);
			return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);

		}
		

/****************************************************************************************************************************
 - Method Name      : deleteWallet
 - Return type      : ResponseEntity<String>
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : Deleting the wallet by mobileNumber from wallet database.
****************************************************************************************************************************/ 		
		
		// http://localhost:9092/wallet/deletewallet/8008020917/
		@RequestMapping(value = "/deletewallet/{mobileNumber}", method = RequestMethod.DELETE)
		public ResponseEntity<String> deleteWallet(@PathVariable("mobileNumber") long mobileNumber) throws WalletNotFoundException {
			String msg= service.deleteWallet(mobileNumber);
			return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);

		}

}
