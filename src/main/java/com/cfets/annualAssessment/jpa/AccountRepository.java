package com.example.jpa;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with AccountRepository
 * User: pual
 * Date: 2016/10/12
 * Desc:
 */
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByAccountName(String accountName);
}
