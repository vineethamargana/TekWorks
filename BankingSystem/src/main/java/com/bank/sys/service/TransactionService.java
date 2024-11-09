package com.bank.sys.service;

import com.bank.sys.dto.TransactionDto;
import com.bank.sys.entity.Transaction;
import com.bank.sys.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepository;

    public TransactionDto createTransaction(TransactionDto transactionDto) 
    {
        Transaction transaction = new Transaction(transactionDto.getTransactionid(), transactionDto.getAmount(),
                transactionDto.getTransactiontype(), null); // Assuming account is set later
        Transaction savedTransaction = transactionRepository.save(transaction);
        return new TransactionDto(savedTransaction.getTransactionid(), savedTransaction.getAmount(),
                savedTransaction.getTransactiontype(), savedTransaction.getAccount().getAccountNum());
    }

    public TransactionDto getTransactionById(int id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
        return new TransactionDto(transaction.getTransactionid(), transaction.getAmount(),
                transaction.getTransactiontype(), transaction.getAccount().getAccountNum());
    }

    public List<TransactionDto> getTransactionsByAccount(String accountNum) {
        List<Transaction> transactions = transactionRepository.findByAccountAccountNum(accountNum);
        return transactions.stream().map(t -> new TransactionDto(t.getTransactionid(), t.getAmount(),
                t.getTransactiontype(), t.getAccount().getAccountNum())).collect(Collectors.toList());
    }

    public TransactionDto updateTransaction(int id, TransactionDto transactionDto) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setAmount(transactionDto.getAmount());
        transaction.setTransactiontype(transactionDto.getTransactiontype());
        Transaction updatedTransaction = transactionRepository.save(transaction);
        return new TransactionDto(updatedTransaction.getTransactionid(), updatedTransaction.getAmount(),
                updatedTransaction.getTransactiontype(), updatedTransaction.getAccount().getAccountNum());
    }

    public void deleteTransaction(int id) {
        transactionRepository.deleteById(id);
    }
}
