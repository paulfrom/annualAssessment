package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created with Account
 * User: pual
 * Date: 2016/10/12
 * Desc:
 */
@Entity(name = "account")
@Data
public class Account extends ResourceSupport{
    @Id
    @GeneratedValue
    private long accountId;
    @Column(unique=true)
    private String accountName;
    @JsonIgnore
    private String password;
    @Column(nullable = false, unique = true)
    private String username;
    @Transient
    private String newpassword;


}
