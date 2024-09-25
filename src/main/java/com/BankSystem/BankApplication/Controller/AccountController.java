package com.BankSystem.BankApplication.Controller;

import com.BankSystem.BankApplication.Entity.Account;
import com.BankSystem.BankApplication.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    AccountService AccService;

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = AccService.getAllAccounts();
        System.out.println(accounts);
        return ResponseEntity.ok(accounts); // Correct way to wrap the response
    }
}
