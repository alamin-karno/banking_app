package com.alaminkarno.bankingapp.controller;

import com.alaminkarno.bankingapp.dto.AccountDto;
import com.alaminkarno.bankingapp.service.AccountService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    // ADD ACCOUNT REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(service.createAccount(accountDto), HttpStatus.CREATED);
    }

    // GET ACCOUNT REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = service.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }

    // DEPOSIT REST API
    @PutMapping("/{id}/deposit")
    public  ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = service.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    // WITHDRAW REST API
    @PutMapping("/{id}/withdraw")
    public  ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = service.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    // GET ALL ACCOUNTS REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
       List<AccountDto> accountDtoList = service.getAllAccounts();
       return ResponseEntity.ok(accountDtoList);
    }

    // DELETE ACCOUNT BY ID REST API
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteAccount(@PathVariable Long id){
        service.deleteAccount(id);
        return ResponseEntity.ok("Account delete successfully.");
    }
}
