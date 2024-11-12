package com.bank.sys.entity;
import java.time.LocalDateTime;

import com.bank.sys.enums.TransType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private LocalDateTime transactionDate;
   // private TransType transactionType;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * 
	 */
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param amount
	 * @param transactionDate
	 * @param account
	 */
	public Transaction(Long id, Double amount, LocalDateTime transactionDate, Account account) {
		super();
		this.id = id;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.account = account;
	}

}
