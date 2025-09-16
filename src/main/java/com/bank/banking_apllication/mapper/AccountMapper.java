package com.bank.banking_apllication.mapper;

import com.bank.banking_apllication.DTO.AccountDto;
import com.bank.banking_apllication.Model.Account;

public class AccountMapper {

    public static Account maptoAccount(AccountDto accountDto) {

        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance());

        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {

        AccountDto accountDto = new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());

        return accountDto;
    }
}
