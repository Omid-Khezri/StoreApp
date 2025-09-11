package com.storeapp.service;

import com.storeapp.model.Account;
import com.storeapp.model.Roleenum;
import com.storeapp.repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    public AccountService(PasswordEncoder passwordEncoder, AccountRepository accountRepository) {
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
    }
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccount(long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account createAccount(String name, String email, String rawPassword, Roleenum role) {
        Account acc = new Account();
        acc.setName(name);
        acc.setEmail(email);
        acc.setRole(role);
        acc.setPassword(passwordEncoder.encode(rawPassword));
        return accountRepository.save(acc);
    }
}