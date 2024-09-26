package com.BankSystem.BankApplication.Service;

import com.BankSystem.BankApplication.Entity.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    public List<Account> getAllAccounts();
    public Account saveAccount(Account account);
    public Optional<Account> getAccountById(Long id);
    public void deleteAccount(Long id);
}
