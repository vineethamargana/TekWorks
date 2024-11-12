package com.bank.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sys.dto.AccountDTO;
import com.bank.sys.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

//	List<AccountDTO> findByaccountId(Long userId);
}