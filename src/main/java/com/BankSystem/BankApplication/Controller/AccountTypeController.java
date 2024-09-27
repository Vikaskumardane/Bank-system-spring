package com.BankSystem.BankApplication.Controller;


import com.BankSystem.BankApplication.Entity.AccountType;
import com.BankSystem.BankApplication.Service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accountTypes")
public class AccountTypeController {

    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping
    public List<AccountType> getAllAccountTypes() {
        return accountTypeService.getAllAccountTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountType> getAccountTypeById(@PathVariable Long id) {
        AccountType accountType = accountTypeService.getAccountTypeById(id);
        return ResponseEntity.ok(accountType);
    }
}
