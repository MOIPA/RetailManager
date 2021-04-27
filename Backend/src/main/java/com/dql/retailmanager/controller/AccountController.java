package com.dql.retailmanager.controller;

import com.dql.retailmanager.entity.Account;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.service.IAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountController {
    @Resource
    IAccountService accountService;

    @GetMapping("/getAccountById")
    public Account getAccountById(@RequestParam int id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/deleteAccountById")
    public int deleteAccountById(@RequestParam int id) {
        return accountService.deleteById(id);
    }

    @GetMapping("/deleteAccountByIds")
    public int deleteAccountByIds(@RequestParam int[] ids) {
        for (int id : ids) {
            accountService.deleteById(id);
        }
        return ids.length;
    }

    @PostMapping("/addAccount")
    public int addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @PostMapping("/updateAccountById")
    public int updateAccount(@RequestBody Account account) {
        return accountService.updateById(account);
    }

    @PostMapping("/listAccountByPage")
    public Object listAccountByPage(@RequestBody SearchForm pageRequest) {
        return accountService.listAccountByPage(pageRequest);
    }

    @GetMapping("/activeAccountById")
    public int activeAccount(@RequestParam int id) {
        return accountService.activeAccount(id);
    }
}
