package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.rainbow.business.service.TransactionService;
import edu.mum.rainbow.common.model.Transaction;

@RestController
@RequestMapping({"/tranx"})
public class TransactionController {
	
	@Autowired
	private TransactionService  transactionService;

	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void createTransaction(@RequestBody Transaction transaction) {
		transactionService.createTransaction(transaction);
	}
	
	
	@RequestMapping("/{clientNo}")
	public List<Transaction> getClientTransactions(@PathVariable("clientNo") String clientNo) {
		List<Transaction> clientTransactions = transactionService.fetchTransactionsByClient(clientNo);
		return clientTransactions;
	}	
	
}
