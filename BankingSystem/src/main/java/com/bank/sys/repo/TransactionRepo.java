package com.bank.sys.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sys.entity.Account;

public interface TransactionRepo extends JpaRepository<Account, Integer> {

}
