package com.BankSystem.BankApplication.Repo;

import com.BankSystem.BankApplication.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public ResponseEntity<Account> findByCustomerName(String customerName);
}
