package com.bank.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.sys.dto.AccountDTO;
import com.bank.sys.dto.ApiResponse;
import com.bank.sys.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	AccountService accountService;

    @PostMapping("/create account")
    public ResponseEntity<ApiResponse<AccountDTO>> createAccount(@RequestBody AccountDTO accountDTO) {
        AccountDTO dto = accountService.createAccount(accountDTO);
        ApiResponse<AccountDTO> response = new ApiResponse<AccountDTO>("Account created successfully",dto);
        return new ResponseEntity<ApiResponse<AccountDTO>>(response,HttpStatus.CREATED);
    }

    @GetMapping("/get all accounts")
    public ResponseEntity<ApiResponse<List<AccountDTO>>> getAllAccounts() {
    	List<AccountDTO> list = accountService.getAllAccounts();
        ApiResponse<List<AccountDTO>> response = new ApiResponse<List<AccountDTO>>("List of accounts",list);
        return new ResponseEntity<ApiResponse<List<AccountDTO>>>(response,HttpStatus.OK);

    }
}
