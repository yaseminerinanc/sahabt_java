package com.example.banking.application;

import com.example.banking.domain.Account;

public class BankingApp {

	public static void main(String[] args) {
		
		//acc:Local+reference Variable
	
		Account acc= //acc ->Stack
				//Heap
				
			new Account("tr1",10000); //heap object
		acc.withdraw(1000);
		//x: Local + value -typed variable -> Stack
		System.err.println(acc.getBalance());
		System.err.println(acc);
	}

}
