package com.BankSystem.BankApplication.Service;

import com.BankSystem.BankApplication.Entity.Account;
import com.BankSystem.BankApplication.Repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository AccRepo;

    //get all account details
    public ResponseEntity<List<Account>> getAllAccounts() {
        return (ResponseEntity<List<Account>>) AccRepo.findAll();
    }

}
