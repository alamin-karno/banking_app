package com.alaminkarno.bankingapp.repository;

import com.alaminkarno.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {



}
