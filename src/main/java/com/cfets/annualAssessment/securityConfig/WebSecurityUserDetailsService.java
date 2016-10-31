package com.example.securityConfig;

import com.example.entity.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by woniper on 15. 3. 6..
 */
@Service
public class WebSecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = accountService.getAccountByUserName(accountName);
        if(account == null)
            throw new UsernameNotFoundException(accountName);

        return new WebSecurityUserDetails(account);
    }
}
