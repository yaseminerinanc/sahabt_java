package com.example.banking.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.banking.domain.AccountStatus.AccountStatus;

public class Bank {
	private final int id;
	private String commercialName;

	private final BankType type;
	private Map<String, Customer> customers = new HashMap<>();

	public Bank(int id, String commercialName, BankType type) {
		this.id = id;
		this.commercialName = commercialName;
		this.type = type;
	}


	public int getId() {
		return id;
	}

	public BankType getType() {
		return type;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}

	public void setCustomers(Map<String, Customer> customers) {
		this.customers = customers;
	}
	
	public List<Customer> getCustomers() {
		
		return customers.values().stream().toList();
		
	}

	public Customer createCustomer(String identity, String fullname) {
	
		return customers.put(identity, new Customer (identity, fullname));
	
	}

	public Optional<Customer> findCustomerByIdentity(String identity) {
		
		return Optional.ofNullable(customers.get(identity));
	}

	public double getTotalBalance(AccountStatus... status) {
		// TODO: Return total balances of all customers where accounts are in the given
		// status
		// NOTE: "AccountStatus... status" means it is an array
		// You can call getTotalBalance() as in the following examples:
		// var activeTotal = garantiBbva.getTotalBalance(AccountStatus.ACTIVE);
		// var activeAndBlockedTotal = garantiBbva.getTotalBalance(AccountStatus.ACTIVE,
		// AccountStatus.BLOCKED);
		// var allTotal = garantiBbva.getTotalBalance(); // or
		// var allTotal = garantiBbva.getTotalBalance( AccountStatus.ACTIVE,
		// AccountStatus.BLOCKED,AccountStatus.CLOSED);
		return 0.0;

	}
}
