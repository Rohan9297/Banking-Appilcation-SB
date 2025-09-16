package com.bank.banking_apllication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.banking_apllication.DTO.AccountDto;
import com.bank.banking_apllication.services.AccountServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    AccountServices accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

    }

    @GetMapping("/getAccount/{AccountNumber}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long AccountNumber) {
        AccountDto accountDto = accountService.geAccountById(AccountNumber);

        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposite")
    public ResponseEntity<AccountDto> depositeAmount(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.depositeAmmount(id, amount);

        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAmmount(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdrawAmmount(id, amount);

        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accountDto = accountService.getAllAccountDto();
        return ResponseEntity.ok(accountDto);

    }

    @DeleteMapping("/{id}/deleteAccount")
    public ResponseEntity<String> deleteAccoount(@PathVariable Long id) {

        accountService.deletAccountDto(id);
        return ResponseEntity.ok(" Account is deleted succesfully");
    }

}
