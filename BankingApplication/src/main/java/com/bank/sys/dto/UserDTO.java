package com.bank.sys.dto;

import java.util.List;

import com.bank.sys.entity.Account;
import com.bank.sys.entity.User;

public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String phn;
	//private List<Account> accounts;

//	public List<Account> getAccounts() {
//		return accounts;
//	}
//
//	public void setAccounts(List<Account> accounts) {
//		this.accounts = accounts;
//	}

	public String getPhn() {
		return phn;
	}

	public void setPhn(String phn) {
		this.phn = phn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public UserDTO(Long id, String name, String email, String phn, List<Account> accounts) {
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.phn = phn;
//		this.accounts = accounts;
//	}

	public UserDTO(Long id, String name, String email, String phn) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phn = phn;
	}

	public UserDTO(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

//	public UserDTO(User user) {
//		this.id = user.getId();
//		this.name = user.getName();
//		// TODO Auto-generated constructor stub
//	}

}
