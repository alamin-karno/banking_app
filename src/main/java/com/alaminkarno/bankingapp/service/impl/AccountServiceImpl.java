package com.alaminkarno.bankingapp.service.impl;

import com.alaminkarno.bankingapp.dto.AccountDto;
import com.alaminkarno.bankingapp.entity.Account;
import com.alaminkarno.bankingapp.mapper.AccountMapper;
import com.alaminkarno.bankingapp.repository.AccountRepository;
import com.alaminkarno.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = repository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
      Account account =  repository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
      return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =  repository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));

        double total = account.getBalance() + amount;
        account.setBalance(total);

        Account savedAccount =  repository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account =  repository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient amount!");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);

        Account savedAccount = repository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = repository.findAll();
        return  accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
        repository.deleteById(id);
    }
}
