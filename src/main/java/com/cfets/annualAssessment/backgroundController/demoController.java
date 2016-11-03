package com.cfets.annualAssessment.backgroundController;

import com.cfets.annualAssessment.entity.Account;
import com.cfets.annualAssessment.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by liusonglin on 2016/11/2.
 */
@Controller
@RequestMapping("/admin/demo")
public class DemoController {

    @Resource private AccountService accountService;

    @GetMapping
    public String index(Model model){
        List<Account> accountList = accountService.getAccountAll();
        model.addAttribute("accountList",accountList);
        return "demo/list";
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute Account account) {
        return "demo/form";
    }

    @PostMapping
    public ModelAndView create(@Valid Account account, BindingResult result,
                               RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return new ModelAndView("demo/form", "formErrors", result.getAllErrors());
        }
        account = this.accountService.newAccount(account);
        redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
        return new ModelAndView("redirect:/admin/demo/{account.accountId}", "account.accountId", account.getAccountId());
    }

    @GetMapping("/{id}")
    public String view(Model model,@PathVariable("id") long id){
        model.addAttribute("account",accountService.getAccountById(id));
        return "/demo/view";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteAccount(Model model,@PathVariable long id){
        boolean flag = this.accountService.deleteAccount(id);
        return flag;
    }

    @GetMapping("/modify/{id}")
    public String modify(Model model,@PathVariable("id") long id){
        model.addAttribute("account",accountService.getAccountById(id));
        return "demo/form";
    }
}
