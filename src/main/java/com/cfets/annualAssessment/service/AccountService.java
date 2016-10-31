package com.example.service;

import com.example.entity.Account;
import com.example.jpa.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created with UserDetailService
 * User: pual
 * Date: 2016/10/12
 * Desc:
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account getAccountByUserName(String name){
        return accountRepository.findByAccountName(name);
    }

    public Account getAccountById(long id) {
        return accountRepository.findOne(id);
    }

    public Account newAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getNewpassword()));
        return accountRepository.save(account);
    }

    public void deleteAccount(long id){
        accountRepository.delete(id);
    }

    public Account updateAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getNewpassword()));
        return accountRepository.save(account);
    }
}
