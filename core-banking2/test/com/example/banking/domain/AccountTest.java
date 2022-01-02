package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.example.banking.domain.AccountStatus.AccountStatus;

class AccountTest {

	@Test
	@DisplayName("create acount object successfuly")
	
	void createObjectSuccessfuly() {
		//1.test fixture/Setup
		//var sadece local variablelar için kullanabiliriz.
		//2.Call exercise method
		var acc =new Account("tr1",10000);
		//3.verification
		
		assertEquals("tr1",acc.getIban());
		assertEquals(10000,acc.getBalance());
		assertEquals(AccountStatus.ACTIVE, acc.getStatus());
		//4.tear-down
		
	}
	
	@CsvFileSource(resources="accounts.csv")
	@ParameterizedTest
	void depositNegativeAmount(String iban, double balance, double amount) throws Exception {
		
		//test fixture/setup
		var acc =new Account(iban,balance);
		//call exercise method
		var result=acc.deposit(amount);
		//verification
		assertFalse(result);
		assertEquals(balance,acc.getBalance());
		
	}
	
	/*@Test
	void depositPositiveAmountSuccess(String iban, double balance, double amount) throws Exception {
		
		//test fixture/setup
		var acc =new Account("tr1",10000);
		//call exercise method
		var result=acc.deposit(1);
		//verification
		assertTrue(result);
		assertEquals(10001,acc.getBalance());
		
	}*/
	
	@Test
	@DisplayName("set account status successfuly")
	void setAccountStatusSuccessfuly() {
		
		var acc = new Account("tr1", 10000, AccountStatus.ACTIVE);
		acc.setStatus(AccountStatus.CLOSED);
	
	}


}
