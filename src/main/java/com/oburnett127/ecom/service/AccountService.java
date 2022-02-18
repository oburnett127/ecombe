package com.oburnett127.ecom.service;

import java.util.List;

import com.oburnett127.ecom.model.Account;

public interface AccountService {

	Account createAccount(Account Account);
	
	List<Account> getAccounts();
	
	Account getAccount(Integer id);

	Account updateAccount(Account Account);

	void deleteAccount(Integer id);

}