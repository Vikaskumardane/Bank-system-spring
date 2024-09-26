package com.BankSystem.BankApplication.Controller;

import com.BankSystem.BankApplication.Entity.Account;
import com.BankSystem.BankApplication.Exception.ResourceNotFoundException;
import com.BankSystem.BankApplication.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        System.out.println(accounts);
        return ResponseEntity.ok(accounts); // Correct way to wrap the response
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
        return ResponseEntity.ok(account);
    }

    // POST: Create a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountService.saveAccount(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    // PUT: Update an existing account
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(
            @PathVariable Long id,
            @RequestBody Account accountDetails) {

        Optional<Account> existingAccount = accountService.getAccountById(id);

        if (!existingAccount.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Account account = existingAccount.get();
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setCustomerName(accountDetails.getCustomerName());
        account.setBalance(accountDetails.getBalance());
        account.setAccountType(accountDetails.getAccountType());
        // Add more fields if necessary

        Account updatedAccount = accountService.saveAccount(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    // DELETE: Delete an account by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        Optional<Account> existingAccount = accountService.getAccountById(id);

        if (!existingAccount.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
