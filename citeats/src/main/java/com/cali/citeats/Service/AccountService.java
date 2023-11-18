package com.cali.citeats.Service;

import com.cali.citeats.Entity.AccountEntity;
import com.cali.citeats.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }

    public AccountEntity getAccountById(int id) {
        Optional<AccountEntity> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    public AccountEntity createAccount(AccountEntity account) {
        return accountRepository.save(account);
    }

    public AccountEntity updateAccount(int id, AccountEntity account) {
        Optional<AccountEntity> existingAccount = accountRepository.findById(id);

        if (existingAccount.isPresent()) {
            account.setAccountId(id);
            return accountRepository.save(account);
        } else {
            return null;
        }
    }

    public boolean deleteAccount(int id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
