package com.bank.sys.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.sys.dto.TransactionDTO;
import com.bank.sys.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionDTO> deposit(@RequestParam Long accountId, @RequestParam Double amount) 
    {
            TransactionDTO transactionDTO = transactionService.deposit(accountId, amount);
            return new ResponseEntity<>(transactionDTO, HttpStatus.CREATED);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionDTO> withdraw(@RequestParam Long accountId, @RequestParam Double amount) 
    {
            TransactionDTO transactionDTO = transactionService.withdraw(accountId, amount);
            return new ResponseEntity<>(transactionDTO, HttpStatus.CREATED);
    }
}
