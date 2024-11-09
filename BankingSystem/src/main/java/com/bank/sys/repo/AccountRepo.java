package com.bank.sys.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sys.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>
{

//	Optional<Account> findbyaccountNum(String accountNum);
	 List<Account> findByUserId(int userId);

}
