package com.bank.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.sys.dto.ApiResponse;
import com.bank.sys.dto.TransactionDTO;
import com.bank.sys.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
   TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<ApiResponse<TransactionDTO>> deposit(@RequestParam Long accountId, @RequestParam Double amount) 
    {
            TransactionDTO transactionDTO = transactionService.deposit(accountId, amount);
            ApiResponse<TransactionDTO> response = new ApiResponse<TransactionDTO>("Ammount deposited successfully",transactionDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<ApiResponse<TransactionDTO>> withdraw(@RequestParam Long accountId, @RequestParam Double amount) 
    {
            TransactionDTO transactionDTO = transactionService.withdraw(accountId, amount);
            ApiResponse<TransactionDTO> response = new ApiResponse<TransactionDTO>("Ammount withdrawal successful",transactionDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
