 package com.example.banking.domain;

import com.example.banking.domain.AccountStatus.AccountStatus;

public class Account extends Object {
	
	private String iban; //attribute /state/property/data
	protected double balance;// double balance paketler arasında 
	private AccountStatus status ;
	
	//constructor; dönüş tipi olmaz değer dönemez. Initilazation
	//this sözcüğü attribute götürür.Kodun okunurluğunu kolaylaştırır.
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}
	
	

	public Account(String iban, double balance, AccountStatus status) {
		this.iban = iban;
		this.balance = balance;
		this.status = AccountStatus.ACTIVE;
	}



	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}
	
	
	
	public AccountStatus getStatus() {
		return status;
	}



	public void setStatus(AccountStatus status) {
		this.status = status;
	}



	public boolean deposit(double amount) {
		
		//validation
		if (amount <=0) return false;
		//business logic
		this.balance=this.balance + amount;
		return true;
		
		
	}
	public boolean withdraw(double amount) {
		
		System.out.print("Account withdraw");
		//validation
		if (amount <=0) return false;
		//business rule
		if (amount > this.balance) return false;
		this.balance=this.balance - amount;
		return true;
	}
	
	public double withdrawAll() {
		
		var balance=this.balance;
		this.balance=0.0;
		return balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + ", status=" + status + "]";
	}
	

}
