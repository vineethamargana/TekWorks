package com.bank.sys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sys.dto.AccountDTO;
import com.bank.sys.entity.Account;
import com.bank.sys.entity.User;
import com.bank.sys.enums.AccountType;
import com.bank.sys.repository.AccountRepository;
import com.bank.sys.repository.UserRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	UserRepository userRepository;


    public AccountDTO createAccount(AccountDTO accountDTO) {
        User user = userRepository.findById(accountDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        
        Account account = new Account();
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setBalance(accountDTO.getBalance());
        account.setAccountType(accountDTO.getAccountType());
        account.setPinNumber(accountDTO.getPin());
        account.setUser(user);
        
        account = accountRepository.save(account);
        
        return new AccountDTO(account.getId(), account.getAccountNumber(), account.getBalance(), account.getUser().getId(),account.getAccountType());
    }

    public List<AccountDTO> getAllAccounts() {

    	List<Account> accounts = accountRepository.findAll();
    	
    	List<AccountDTO> dtos = new ArrayList<AccountDTO>();
    	for(Account account:accounts)
    	{
    		AccountDTO accdto = new AccountDTO(account.getId(), account.getAccountNumber(), account.getBalance(), account.getAccountType());
    		dtos.add(accdto);
    	}
    	return dtos;
    }
}
