package com.bank.sys.service;

import com.bank.sys.dto.AccountDto;
import com.bank.sys.entity.Account;
import com.bank.sys.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepository;

    public AccountDto createAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.getAccountname(), accountDto.getAccountNum(), accountDto.getAccountType());
        Account savedAccount = accountRepository.save(account);
        return new AccountDto(savedAccount.getAccountid(), savedAccount.getAccountname(), savedAccount.getAccountNum(), savedAccount.getAccountType());
    }

    public AccountDto getAccountById(int id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        return new AccountDto(account.getAccountid(), account.getAccountname(), account.getAccountNum(), account.getAccountType());
    }

    public List<AccountDto> getAccountsByUser(int userId) {
        List<Account> accounts = accountRepository.findByUserId(userId);
        return accounts.stream().map(a -> new AccountDto(a.getAccountid(), a.getAccountname(), a.getAccountNum(), a.getAccountType())).collect(Collectors.toList());
    }

    public AccountDto updateAccount(int id, AccountDto accountDto) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setAccountname(accountDto.getAccountname());
        account.setAccountNum(accountDto.getAccountNum());
        account.setAccountType(accountDto.getAccountType());
        Account updatedAccount = accountRepository.save(account);
        return new AccountDto(updatedAccount.getAccountid(), updatedAccount.getAccountname(), updatedAccount.getAccountNum(), updatedAccount.getAccountType());
    }

    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }
}
