/************************************************************************************************************************************
 - File Name        : WalletServiceImplementation Class
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : This is an service implementation class where all the business logic is written for wallet.
**************************************************************************************************************************************/

package com.cg.ewallet.walletaccount.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ewallet.walletaccount.dao.WalletRepository;
import com.cg.ewallet.walletaccount.dto.WalletEntity;
import com.cg.ewallet.walletaccount.exception.WalletExistException;
import com.cg.ewallet.walletaccount.exception.WalletNotFoundException;
import com.cg.ewallet.walletaccount.model.Wallet;

@Service
	public class  WalletServiceImpl implements WalletService {
		@Autowired
		WalletRepository repository;

/************************************************************************************************************************************
 - Method Name      : viewWallet
 - Return type      : List
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : Fetching all wallet information from wallet database.
*************************************************************************************************************************************/
		
		@Override
		public List<Wallet> viewWallet() {
			// TODO Auto-generated method stub
			List<WalletEntity> entityList=repository.findAll();
			List<Wallet> newWalletList = new ArrayList<>();
			for (WalletEntity entity : entityList) {
				 Wallet wallet = new Wallet();
				 wallet.setMobileNumber(entity.getMobileNumber());
				 wallet.setName(entity.getName());
				 wallet.setEmail(entity.getEmail());
				 wallet.setBalance(entity.getBalance());
				 wallet.setPassword(entity.getPassword());
				 newWalletList.add(wallet);
		}
			return newWalletList;
		}
		
/************************************************************************************************************************************
 - Method Name      : getWalletByMobileNumber
 - Input Parameters : mobileNumber
 - Return type      : WalletEntity
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : Fetching the wallet information from wallet database by mobileNumber.
*************************************************************************************************************************************/ 		

		@Override
		public WalletEntity getWalletByMobileNumber(long mobileNumber) throws WalletNotFoundException{
			
			Optional<WalletEntity> entity = repository.findById(mobileNumber);
			if(entity.isPresent()) {
				return entity.get();
			}
			else {
				throw new WalletNotFoundException("Wallet not found for given Mobile Number");
			}
		}
		
/************************************************************************************************************************************
 - Method Name      : addWallet
 - Input Parameters : WalletEntity
 - Return type      : String
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : Inserting the wallet information into wallet database.
*************************************************************************************************************************************/ 	
				
		@Override
		public String addWallet(WalletEntity wallet) throws WalletExistException{
			
			Optional<WalletEntity> entity = repository.findById(wallet.getMobileNumber());
			if (!entity.isPresent()) {
				repository.save(wallet);
				return "Wallet Added Successfully";
			}
			else {
				throw new WalletExistException("Wallet already exist");
			}
		}
		
/************************************************************************************************************************************
 - Method Name      : updateWallet
 - Return type      : String
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : Updating all pending wallet status by mobile number.
*************************************************************************************************************************************/
		
		@Override
		public String updateWallet(long mobileNumber, WalletEntity wallet) throws WalletNotFoundException{
			
			Optional<WalletEntity> entity = repository.findById(mobileNumber);
			
			if (entity.isPresent()) {
				wallet.setMobileNumber(mobileNumber);
				repository.save(wallet);

				return "Wallet status updated successfully!";
			} else {
				throw new WalletNotFoundException("Wallet not found for given Mobile Number");
			}
		}
		
/************************************************************************************************************************************
 - Method Name      : deletWallet
 - Return type      : String
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : deleting wallet by mobile number.
*************************************************************************************************************************************/
		
		@Override
		public String deleteWallet(long mobileNumber) throws WalletNotFoundException {
			
			Optional<WalletEntity> entity = repository.findById(mobileNumber);
			
			if(entity.isPresent()) {
				repository.deleteById(mobileNumber);
				return "Wallet deleted successfully!";
			}
			else {
				throw new WalletNotFoundException("Wallet not found for given Mobile Number");
			}
		}
}
