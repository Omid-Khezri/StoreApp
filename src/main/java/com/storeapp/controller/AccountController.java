package com.storeapp.controller;

import com.storeapp.config.JwtUtil;
import com.storeapp.dto.AccountRequest;
import com.storeapp.model.Account;
import com.storeapp.service.AccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> account = accountService.getAllAccounts();
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<Account> getAccount(Long id){
        var account = accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountRequest request) {
        Account account = accountService.createAccount(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getRole()
        );
        return ResponseEntity.ok(account);
    }
    public ResponseEntity<?> login(@RequestBody AccountRequest request) {
        // Implement login logic here
        String token = JwtUtil.generatetoken(
            request.getEmail(),
            Map.of("role", request.getRole())
        );
        return ResponseEntity.ok(Map.of("jwtToken", token));
    }
}
