package com.cfets.annualAssessment.entity;

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
@Data
public class Account{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private String accountName;
    @JsonIgnore
    private String password;
    private String username;
    @Transient
    private String newpassword;


}
