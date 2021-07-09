package bank.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bank.Utils;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.observers.EmailSender;
import bank.observers.Logger;
import bank.observers.Observable;
import bank.observers.Observer;
import bank.observers.SMSSender;

public class AccountService extends Observable implements IAccountService{
	private IAccountDAO accountDAO;

	public AccountService() {
		accountDAO = new AccountDAO();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		notifyEmailSender(Utils.ACCOUNT_CREATED + accountNumber);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		notifyLogger(Utils.ACCOUNT_DEPOSIT + accountNumber + Utils.AMOUNT + amount);
		notifySMSSender(Utils.ACCOUNT_DEPOSIT + accountNumber + Utils.AMOUNT + amount);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		notifyLogger(Utils.ACCOUNT_WITHDRAW + accountNumber + Utils.AMOUNT + amount);
		notifySMSSender(Utils.ACCOUNT_WITHDRAW + accountNumber + Utils.AMOUNT + amount);
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		notifyLogger(Utils.ACCOUNT_TRANSFER_FUNDS + Utils.FROM + fromAccountNumber + Utils.TO + toAccountNumber
				+ Utils.AMOUNT + amount);
		notifySMSSender(Utils.ACCOUNT_TRANSFER_FUNDS + Utils.FROM + fromAccountNumber + Utils.TO + toAccountNumber
				+ Utils.AMOUNT + amount);
	}
	
	public void notifyLogger(String msg) {
		for (Observer observer:observers) {
			if (observer instanceof Logger)
				observer.update(msg);
		}
	}
	
	public void notifySMSSender(String msg) {
		for (Observer observer:observers) {
			if (observer instanceof SMSSender)
				observer.update(msg);
		}
	}
	
	public void notifyEmailSender(String msg) {
		for (Observer observer:observers) {
			if (observer instanceof EmailSender)
				observer.update(msg);
		}
	}
}
