/****************************************************************************************************************************
 - File Name        : WalletRepository Interface
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : This interface extends JpaRepository for CRUD operation of WalletEntity class
****************************************************************************************************************************/ 
package com.cg.ewallet.walletaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ewallet.walletaccount.dto.WalletEntity;

public interface WalletRepository extends JpaRepository<WalletEntity, Long>{
	
}
