package com.bank.sys.dto;

import com.bank.sys.enums.AccountType;

public class AccountDTO {
	    private Long id;
	    private String accountNumber;
	    private Double balance;
	    private Long userId;
	    private AccountType accountType;
	    private int pin;
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public Double getBalance() {
			return balance;
		}
		public void setBalance(Double balance) {
			this.balance = balance;
		}
		public Long getUserId() {
			return userId;
		}
		
		public AccountType getAccountType() {
			return accountType;
		}
		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		
		public int getPin() {
			return pin;
		}
		public void setPin(int pin) {
			this.pin = pin;
		}
		
		/**
		 * @param id
		 * @param accountNumber
		 * @param balance
		 * @param userId
		 * @param accountType
		 */
		public AccountDTO(Long id, String accountNumber, Double balance, Long userId, AccountType accountType) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.balance = balance;
			this.userId = userId;
			this.accountType = accountType;
		}
		/**
		 * @param id
		 * @param accountNumber
		 * @param balance
		 * @param userId
		 */
		public AccountDTO(Long id, String accountNumber, Double balance, Long userId) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.balance = balance;
			this.userId = userId;
		}
		/**
		 * 
		 */
		public AccountDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AccountDTO(Long id, String accountNumber, Double balance, AccountType accountType) {
			// TODO Auto-generated constructor stub
			this.id = id;
			this.accountNumber = accountNumber;
			this.balance = balance;
			this.accountType = accountType;
			
		}


}
