package com.example.controller;

import com.example.entity.Account;
import com.example.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created with IndexController
 * User: pual
 * Date: 2016/10/12
 * Desc:
 */
@RestController
public class IndexController {
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired private AccountService accountService;

    @RequestMapping(value = "/index/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> index(@PathVariable("id")long id){
        Account account = accountService.getAccountById(id);
        List<Link> linkList = new ArrayList<>();
        linkList.add(linkTo(IndexController.class).slash("accounts").withRel("principal"));
        linkList.add(linkTo(IndexController.class).slash("account").slash(account.getAccountId()).withRel("accountId"));
        account.add(linkList);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/add",method = RequestMethod.POST)
    public ResponseEntity<?> newaccount(@RequestBody @Valid Account account, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<> (result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        account = accountService.newAccount(account);
        return new ResponseEntity<>(account,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteId(@PathVariable("id")long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(true,HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/updateAccount/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody @Valid Account account, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<> (result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        account = accountService.updateAccount(account);
        return new ResponseEntity<>(account,HttpStatus.CREATED);
    }
}
