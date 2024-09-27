package com.BankSystem.BankApplication.Service;

import com.BankSystem.BankApplication.Entity.AccountType;

import java.util.List;

public interface IAccountTypeService {
    public List<AccountType> getAllAccountTypes();
    public AccountType getAccountTypeById(Long id);
}
