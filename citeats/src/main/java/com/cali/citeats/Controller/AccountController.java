// AccountController.java
package com.cali.citeats.Controller;

import com.cali.citeats.Entity.AccountEntity;
import com.cali.citeats.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // C - Create an account
    @PostMapping("/createAccount")
    public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountEntity account) {
        AccountEntity createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    // R - Read all accounts
    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<AccountEntity>> getAllAccounts() {
        List<AccountEntity> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // U - Update an account
    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<AccountEntity> updateAccount(@PathVariable int id, @RequestBody AccountEntity account) {
        AccountEntity updatedAccount = accountService.updateAccount(id, account);
        if (updatedAccount != null) {
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // D - Delete an account
    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        if (accountService.deleteAccount(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
