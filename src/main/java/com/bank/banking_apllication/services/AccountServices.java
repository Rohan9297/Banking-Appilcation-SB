package com.bank.banking_apllication.services;

import java.util.List;

import com.bank.banking_apllication.DTO.AccountDto;

public interface AccountServices {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto geAccountById(Long id);

    AccountDto depositeAmmount(Long id, Double amount);

    AccountDto withdrawAmmount(Long id, Double amount);

    List<AccountDto> getAllAccountDto();

    void deletAccountDto(Long id);

}
