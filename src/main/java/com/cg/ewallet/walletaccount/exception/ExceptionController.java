/****************************************************************************************************************************
 - File Name        : ExceptionController Class
 - Author           : Divya Mulinti
 - Creation Date    : 12-06-2020
 - Description      : This is an exception controller which handles the exception for wallet.
****************************************************************************************************************************/
package com.cg.ewallet.walletaccount.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

/****************************************************************************************************************************
 - Method Name      : handleException
 - Input Parameters : WalletNotFoundException
 - Return type      : String
 - Author           : Divya Mulinti
 - Creation Date    : 12-06-2020
 - Description      : This method will return message when wallet status will not found during fetching /updating by walletStatus.
****************************************************************************************************************************/ 		
	
	@ExceptionHandler(WalletNotFoundException.class)
	public String handleException(WalletNotFoundException e) {
		return e.getMessage();
	}
/****************************************************************************************************************************
 - Method Name      : handleException
 - Input Parameters : WalletAlreadyExistException
 - Return type      : String
 - Author           : Divya Mulinti
 - Creation Date    : 12-06-2020
 - Description      : This method will return message when wallet status will already exist during creating wallet.
****************************************************************************************************************************/ 
	
	@ExceptionHandler(WalletExistException.class)
	public String handleException(WalletExistException e) {
		return e.getMessage();
				
	}
/****************************************************************************************************************************
 - Method Name      : genericException
 - Input Parameters : Exception
 - Return type      : ResponseEntity<ErrorMessage>
 - Author           : Divya Mulinti
 - Creation Date    : 12-06-2020
 - Description      : This method will return message when wallet information is not correct.
****************************************************************************************************************************/ 	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> genericException(Exception e) {
		ErrorMessage error=new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	
/****************************************************************************************************************************
 - Method Name      : handleMethodArgumentNotValid
 - Input Parameters : MethodArgumentNotValidException
 - Return type      : String
 - Author           : Divya Mulinti
 - Creation Date    : 12-06-2020
 - Description      : This predefined method will return message for all the non-functional validation for wallet class fields.
****************************************************************************************************************************/ 	

		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
			Map<String, String> errors = new HashMap<>();
			ex.getBindingResult().getFieldErrors()
					.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			return errors;
		}	
	
}
