package bank.dao;

import java.util.*;
import bank.domain.Account;

public class MockAccountDAO implements IAccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		
	}

	public void updateAccount(Account account) {

	}

	public Account loadAccount(long accountnumber) {
		return null;
	}

	public Collection<Account> getAccounts() {
		return accountlist;
	}

}
