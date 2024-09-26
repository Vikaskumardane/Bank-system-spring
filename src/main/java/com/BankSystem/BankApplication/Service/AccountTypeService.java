package com.BankSystem.BankApplication.Service;

import com.BankSystem.BankApplication.Repo.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountTypeService implements IAccountTypeService{

    @Autowired
    AccountTypeRepository AccTypeRepo;


}
