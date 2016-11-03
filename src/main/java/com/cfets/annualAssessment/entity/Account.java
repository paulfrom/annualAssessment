package com.cfets.annualAssessment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
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
    @NotEmpty(message = "用户名不能为空")
    private String accountName;
    @JsonIgnore
    private String password;
    @NotEmpty(message = "用户姓名不能为空")
    private String username;
    @Transient
    @NotEmpty(message = "密码必须填写")
    private String newpassword;


}
