package com.BankSystem.BankApplication.Repo;

import com.BankSystem.BankApplication.Entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {


}
