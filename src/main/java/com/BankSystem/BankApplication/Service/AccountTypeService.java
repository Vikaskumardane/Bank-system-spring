package com.BankSystem.BankApplication.Service;

import com.BankSystem.BankApplication.Entity.AccountType;
import com.BankSystem.BankApplication.Repo.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeService implements IAccountTypeService{

    @Autowired
    AccountTypeRepository AccTypeRepo;

    //get all records
    public List<AccountType> getAllAccountTypes(){
        return AccTypeRepo.findAll();
    }

    //get record by ID
    public AccountType getAccountTypeById(Long id){
        return AccTypeRepo.findById(id).orElseThrow(()-> new RuntimeException("No AccountType found In the database By the Id: "+id));
    }


}
