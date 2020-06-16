/****************************************************************************************************************************
 - File Name        : EwalletMSApplication Class
 - Author           : Divya Mulinti
 - Creation Date    : 11-06-2020
 - Description      : This file consist the main class for the wallet microservice.
****************************************************************************************************************************/
package com.cg.ewallet.walletaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EwalletMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwalletMsApplication.class, args);
	}

}
