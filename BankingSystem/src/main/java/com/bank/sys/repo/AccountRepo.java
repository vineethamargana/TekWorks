package com.bank.sys.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sys.entity.Account;
import com.bank.sys.entity.Transaction;

public interface AccountRepo extends JpaRepository<Account, Integer>{

//	Optional<Account> findbyaccountNum(String accountNum);

}
