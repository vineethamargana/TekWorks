package com.bank.sys.dto;

import com.bank.sys.enums.AccountType;

public class AccountDto {
	private int accountid;
	private String accountname;
	private String accountNum;
	private AccountType accountType;
	
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDto(int accountid, String accountname, String accountNum, AccountType accountType) {
		super();
		this.accountid = accountid;
		this.accountname = accountname;
		this.accountNum = accountNum;
		this.accountType = accountType;
	}
	
	public int getAccountid() {
		return accountid;
	}
	
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	
	public String getAccountname() {
		return accountname;
	}
	
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "AccountDto [accountid=" + accountid + ", accountname=" + accountname + ", accountNum=" + accountNum
				+ ", accountType=" + accountType + "]";
	}

}
