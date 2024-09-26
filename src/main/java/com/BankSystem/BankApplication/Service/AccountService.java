package com.BankSystem.BankApplication.Service;

import com.BankSystem.BankApplication.Entity.Account;
import com.BankSystem.BankApplication.Repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository AccRepo;

    //get all account details
    public List<Account> getAllAccounts() {
        return  AccRepo.findAll(); // Returns list, not ResponseEntity
    }

    // Save or update an account
    public Account saveAccount(Account account) {
        return AccRepo.save(account);
    }

    // Get account by ID
    public Optional<Account> getAccountById(Long id) {
        return AccRepo.findById(id);
    }

    // Delete account by ID
    public void deleteAccount(Long id) {
        AccRepo.deleteById(id);
    }
}
