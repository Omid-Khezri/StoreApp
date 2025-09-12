package com.storeapp.controller;

<<<<<<< HEAD
import com.storeapp.config.JwtUtil;
import com.storeapp.dto.AccountRequest;
import com.storeapp.model.Account;
import com.storeapp.service.AccountService;

=======
import com.storeapp.dto.AccountRequest;
import com.storeapp.model.Account;
import com.storeapp.model.Roleenum;
import com.storeapp.service.AccountService;
>>>>>>> f7b2480b7a793429ea2ae60fb627f730e2fc91d2
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> f7b2480b7a793429ea2ae60fb627f730e2fc91d2

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
<<<<<<< HEAD
    public ResponseEntity<?> login(@RequestBody AccountRequest request) {
        // Implement login logic here
        String token = JwtUtil.generatetoken(
            request.getEmail(),
            Map.of("role", request.getRole())
        );
        return ResponseEntity.ok(Map.of("jwtToken", token));
    }
=======
>>>>>>> f7b2480b7a793429ea2ae60fb627f730e2fc91d2
}
