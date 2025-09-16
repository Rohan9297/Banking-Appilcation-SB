package com.bank.banking_apllication.services;

import com.bank.banking_apllication.DTO.AccountDto;

public interface AccountServices {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto geAccountById(Long id);

    AccountDto depositeAmmount(Long id, Double amount);

}
