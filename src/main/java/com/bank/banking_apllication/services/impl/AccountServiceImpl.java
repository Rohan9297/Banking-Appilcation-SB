package com.bank.banking_apllication.services.impl;

import java.util.ArrayList;
import java.util.List;

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
        Double updateAmount = account.getBalance() + amount;
        account.setBalance(updateAmount);
        Account SavedAccount = accoountRepository.save(account);

        return AccountMapper.mapToAccountDto(SavedAccount);
    }

    @Override
    public AccountDto withdrawAmmount(Long id, Double amount) {

        Account account = accoountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("account not found"));

        Double updateAmount = account.getBalance() - amount;

        account.setBalance(updateAmount);
        Account saveAccount = accoountRepository.save(account);

        return AccountMapper.mapToAccountDto(saveAccount);

    }

    @Override
    public List<AccountDto> getAllAccountDto() {

        List<Account> accounts = accoountRepository.findAll();
        List<AccountDto> accountDtos = new ArrayList<>();

        for (Account account : accounts) {
            AccountDto Dtos = AccountMapper.mapToAccountDto(account);
            accountDtos.add(Dtos);
        }

        return accountDtos;

    }

    @Override
    public void deletAccountDto(Long id) {

        Account account = accoountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        accoountRepository.deleteById(id);

    }

}
