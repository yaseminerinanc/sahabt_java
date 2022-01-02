package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

public class StudyPoly {
	
	public static void main(String[] args) {
			Object o;
			o=42;
			o=true;
			o="Jach";
			o=new Account("tr1",10_000);
			o=3.14;
			Account acc=null;
			if(ThreadLocalRandom.current().nextBoolean())
			 acc=new Account("tr1",10_000);
			else 
			 acc=new CheckingAccount("tr1",10_000,5000);
			System.out.println(acc.getClass().getName());
			 acc.withdraw(5000);
	
	}

}
