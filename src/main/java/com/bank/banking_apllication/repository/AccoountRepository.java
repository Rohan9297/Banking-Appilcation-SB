package com.bank.banking_apllication.repository;

import org.springframework.stereotype.Repository;

import com.bank.banking_apllication.Model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccoountRepository extends JpaRepository<Account, Long> {

    // void saveAll(AccountDto accountDto);

}
