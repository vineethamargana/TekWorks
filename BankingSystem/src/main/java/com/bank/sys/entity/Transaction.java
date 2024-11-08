package com.bank.sys.entity;

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
	private int transactionid;
	private double amount;
	private String transactiontype;
	
	@ManyToOne
    @JoinColumn(name = "account_id")
	private Account account; //many to one 
	
	public Transaction() {
		super();
	}

	public Transaction(int transactionid, double amount, String transactiontype, Account account) {
		super();
		this.transactionid = transactionid;
		this.amount = amount;
		this.transactiontype = transactiontype;
		this.account = account;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", amount=" + amount + ", transactiontype="
				+ transactiontype + ", account=" + account + "]";
	}
}
