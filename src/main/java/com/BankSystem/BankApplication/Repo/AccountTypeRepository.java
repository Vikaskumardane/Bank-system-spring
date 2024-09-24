package com.BankSystem.BankApplication.Repo;

import com.BankSystem.BankApplication.Entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
}
