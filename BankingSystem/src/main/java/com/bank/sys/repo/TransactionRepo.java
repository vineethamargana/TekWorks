package com.bank.sys.repo;

import com.bank.sys.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByAccountAccountNum(String accountNum);
}
