package com.bank.banking_apllication.services.impl;

import org.springframework.stereotype.Service;

import com.bank.banking_apllication.DTO.AccountDto;
import com.bank.banking_apllication.Model.Account;
import com.bank.banking_apllication.mapper.AccountMapper;
import com.bank.banking_apllication.repository.AccoountRepository;
import com.bank.banking_apllication.services.AccountServices;

@Service
public class AccountServiceImpl implements AccountServices {

    private AccoountRepository accoountRepository;

    public AccountServiceImpl(AccoountRepository accoountRepository) {
        this.accoountRepository = accoountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.maptoAccount(accountDto);
        Account accountSaved = accoountRepository.save(account);
        return AccountMapper.mapToAccountDto(accountSaved);
    }

    @Override
    public AccountDto geAccountById(Long id) {

        Account account = accoountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("account id is not found"));
        return AccountMapper.mapToAccountDto(account);

    }

    @Override
    public AccountDto depositeAmmount(Long id, Double amount) {

        Account account = accoountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("account not found"));
        double updateAmount = account.getBalance() + amount;
        account.setBalance(updateAmount);
        Account SavedAccount = accoountRepository.save(account);

        return AccountMapper.mapToAccountDto(SavedAccount);
    }

}
