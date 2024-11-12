package com.bank.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sys.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
