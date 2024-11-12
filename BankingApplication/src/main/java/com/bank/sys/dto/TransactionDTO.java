package com.bank.sys.dto;

import java.time.LocalDateTime;

public class TransactionDTO {
    
    private Long id;
    private Double amount;
    private LocalDateTime transactionDate;
    private Long accountId;

    // Constructor
    public TransactionDTO(Long id, Double amount, LocalDateTime transactionDate, Long accountId) {
        this.id = id;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountId = accountId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
