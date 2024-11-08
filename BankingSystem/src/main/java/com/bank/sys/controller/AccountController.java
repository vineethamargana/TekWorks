package com.bank.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.sys.entity.Account;
import com.bank.sys.repo.AccountRepo;
import com.bank.sys.service.AccountService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/banksys/users/Accounts")
public class AccountController {

//	@Autowired
//	AccountService as;
//	
//	@PostMapping("/createaccount")
//	public String createAccount(@RequestBody Account account) 
//	{
//	       as.createAccount(account);	
//	       return "Account created ";
//	}
	
}
