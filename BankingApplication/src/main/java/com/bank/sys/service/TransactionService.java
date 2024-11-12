package com.bank.sys.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sys.dto.TransactionDTO;
import com.bank.sys.entity.Account;
import com.bank.sys.entity.Transaction;
import com.bank.sys.exceptions.AccountNotFoundException;
import com.bank.sys.exceptions.InsufficientFundsException;
import com.bank.sys.repository.AccountRepository;
import com.bank.sys.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
    AccountRepository accountRepository;


    public TransactionDTO deposit(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAccount(account);
        account.setBalance(account.getBalance() + amount);
        transactionRepository.save(transaction);
        accountRepository.save(account);

        return new TransactionDTO(transaction.getId(), transaction.getAmount(), transaction.getTransactionDate(), transaction.getAccount().getId());
    }


    public TransactionDTO withdraw(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        
        Transaction transaction = new Transaction();
        transaction.setAmount(-amount);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAccount(account);

        account.setBalance(account.getBalance() - amount);
        transactionRepository.save(transaction);
        accountRepository.save(account);

        return new TransactionDTO(transaction.getId(), transaction.getAmount(), transaction.getTransactionDate(), transaction.getAccount().getId());
    }
}
