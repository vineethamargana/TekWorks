package com.bank.sys.entity;
import java.util.List;
import com.bank.sys.enums.AccountType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Account {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountid;
   @Column(nullable = false)
	private String accountname; // personal,business
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType; // like savings, current
	
	@Column(nullable = false)
	private String pinNumber;
	
	@Column(unique = true)
	private String accountNum;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user; //many to one
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Transaction> transactions; //one to many
	
	public Account() {
		super();
	}
	public Account(int accountid, String accountname, AccountType accountType, String pinNumber, String accountNum,
			User user) {
		super();
		this.accountid = accountid;
		this.accountname = accountname;
		this.accountType = accountType;
		this.pinNumber = pinNumber;
		this.accountNum = accountNum;
		this.user = user;
	}
	public Account(int accountid, String accountname, AccountType accountType, String accountNum, User user,
			List<Transaction> transactions) {
		super();
		this.accountid = accountid;
		this.accountname = accountname;
		this.accountType = accountType;
		this.accountNum = accountNum;
		this.user = user;
		this.transactions = transactions;
	}
	
	public Account(String accountname, String accountNum, AccountType accountType) {
		this.accountname = accountname;
		this.accountType = accountType;
		this.accountNum = accountNum;
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
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	
}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountname=" + accountname + ", accountType=" + accountType
				+ ", accountNum=" + accountNum + ", user=" + user + ", transactions=" + transactions + "]";
	}	
}
