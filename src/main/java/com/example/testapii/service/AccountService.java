package com.example.testapii.service;

import com.example.testapii.model.Account;
import com.example.testapii.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account save(Account account) {
        return repository.save(account);
    }


    @Transactional
    public Account findAccount(String username) {
        return repository.getOne(username);
    }

    @Transactional
    public Account login(String username, String password) {
        Account account = repository.getAccountByUsernameAndPassword(username, password);
        return account != null ? account : null;
    }
}
