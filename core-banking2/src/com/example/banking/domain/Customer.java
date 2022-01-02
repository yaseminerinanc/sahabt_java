package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Customer {
	
	private final String identity;
	private String fullName;
	//private List<Account> accounts =new ArrayList<>();
	private Map<String ,Account> accounts =new  HashMap<>();
	
	//final alan tanımladıysak constructorda this.identity şeklinde initiliaze etmem gerek.
	public Customer(String identity, String fullName) {
		this.identity = identity;
		this.fullName = fullName;
		accounts=new HashMap();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentity() {
		return identity;
	}
	
	public void addAccount(Account account) {
		accounts.put(account.getIban(), account);
	}
	
	/*public void addAccount(Account account) {
		accounts.add(account);
	}*/
	
	public Optional<Account> removeAccount(int index) {
		if (index < 0 || index >= accounts.size())
			return Optional.empty();
		return Optional.of(accounts.remove(index));
	}
	
	public Optional<Stream<Account>> removeAccount(String iban){
		
		Optional<Stream<Account>> account = Optional.ofNullable(accounts.values().stream().filter(a -> a.getIban().equals(iban)));
		account.ifPresent(acc -> accounts.remove(acc));
		
		return account;
	
	}
	
	/*public Optional <Account> removeAccount(String iban) {
		Account foundAccount = null;
		for (var account : accounts) {
			if (account.getIban().equals(iban)) {
				foundAccount = account;	break;
			}
		}	
		if (Objects.nonNull(foundAccount)) {
			accounts.remove(foundAccount);
		}
		return Optional.ofNullable(foundAccount);
	}*/
	
	/*public List<Account> getAccounts(){
		return Collections.unmodifiableList(accounts);
	}*/
	
	public Map<String, Account> getAccounts() {
		return accounts;
	}
	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullName=" + fullName + "]";
	
	}
	
	public double getBalance() {
		
		return accounts.values()
						.stream()
						.mapToDouble(Account::getBalance)
						.sum();
	}
	
}


