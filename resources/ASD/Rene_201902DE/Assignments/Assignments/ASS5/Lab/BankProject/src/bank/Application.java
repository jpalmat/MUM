package bank;

import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;
import command.DepositCommand;
import command.HistoryList;
import command.TransferFundsCommand;
import command.WithdrawCommand;

public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		HistoryList historyList = new HistoryList();
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		// use account 1;
		DepositCommand deposit = new DepositCommand(1263862, 240, (AccountService) accountService);
		deposit.execute();
		historyList.addCommand(deposit);

		deposit = new DepositCommand(1263862, 529, (AccountService) accountService);
		deposit.execute();
		historyList.addCommand(deposit);

		WithdrawCommand withdraw = new WithdrawCommand(1263862, 230, (AccountService) accountService);
		withdraw.execute();
		historyList.addCommand(withdraw);

		// use account 2;
		deposit = new DepositCommand(4253892, 12450, (AccountService) accountService);
		deposit.execute();
		historyList.addCommand(deposit);

		TransferFundsCommand transferFunds = new TransferFundsCommand(4253892, 1263862, 100, "payment of invoice 10232",
				(AccountService) accountService);
		transferFunds.execute();
		historyList.addCommand(transferFunds);

		// show balances

		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println(
					"-Date-------------------------" + "-Description------------------" + "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
						entry.getAmount());
			}
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}

		// undo
		historyList.undo();
		
		System.out.println("-----------------------After undo-------------------");

		// show balances
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println(
					"-Date-------------------------" + "-Description------------------" + "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
						entry.getAmount());
			}
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}

	}

}
