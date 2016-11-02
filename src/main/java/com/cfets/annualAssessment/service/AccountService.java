package com.cfets.annualAssessment.service;

import com.cfets.annualAssessment.entity.Account;
import com.cfets.annualAssessment.mapper.AccountMapper;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
        Example example = new Example(Account.class);
        example.createCriteria().andGreaterThan("accountName", name);
        List<Account> list = (List<Account>) accountMapper.selectByExample(name);
//        return accountRepository.findByAccountName(name);
        return list.get(0);
    }

    public Account getAccountById(long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    public Account newAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getNewpassword()));
        accountMapper.insertUseGeneratedKeys(account);
        return account;
    }

    public void deleteAccount(long id){
        System.out.print(accountMapper.deleteByPrimaryKey(id));
    }

    public Account updateAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getNewpassword()));
        accountMapper.updateByPrimaryKey(account);
        return account;
    }
}
