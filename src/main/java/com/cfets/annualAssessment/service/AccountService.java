package com.cfets.annualAssessment.service;

import com.cfets.annualAssessment.entity.Account;
import com.cfets.annualAssessment.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created with UserDetailService
 * User: pual
 * Date: 2016/10/12
 * Desc:
 */
@Service
public class AccountService {
//    @Autowired
//    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccountByUserName(String name){
            Account account = accountMapper.selectByName(name);
//        return accountRepository.findByAccountName(name);
        return account;
    }

    public Account getAccountById(long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    public Account newAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getNewpassword()));
        accountMapper.insertUseGeneratedKeys(account);
        return account;
    }

    public boolean deleteAccount(long id){
        return accountMapper.deleteByPrimaryKey(id)>0;
    }

    public Account updateAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getNewpassword()));
        accountMapper.updateByPrimaryKey(account);
        return account;
    }

    public List<Account> getAccountAll() {
        return  accountMapper.selectAll();
    }
}
