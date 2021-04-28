package com.dql.retailmanager.controller;

import com.dql.retailmanager.Utils.Uuid;
import com.dql.retailmanager.entity.Account;
import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.Purchase;
import com.dql.retailmanager.entity.RetailOrder;
import com.dql.retailmanager.entity.form.OrderForm;
import com.dql.retailmanager.entity.form.RetailOrderForm;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/retail")
@CrossOrigin
public class RetailController {
    @Resource
    IRetailOrderService retailOrderService;
    @Resource
    IItemService itemService;
    @Resource
    IAccountService accountService;
    @Resource
    IStorageService storageService;

    @GetMapping("/deleteByRetailCode")
    public int deleteByRetailCode(@RequestParam List<String> code) {
        try {
            int i = code.stream().mapToInt(x -> retailOrderService.deleteById(x)).sum();
            if (i <= 0) return -1;
        } catch (Exception e) {
            return -2;
        }
        return 1;
    }

    @PostMapping("/listRetailOrderByPage")
    public Object listRetailOrderByPage(@RequestBody SearchForm searchForm) {
        return retailOrderService.listRetailOrderByPage(searchForm);
    }

    @PostMapping("/addRetailOrder")
    public int addSellingOrder(@RequestBody RetailOrderForm orderForm) {
        // check default account
        List<Account> accountList = accountService.getActivitedAccount();
        // -2 no pay account
        if (accountList == null || accountList.size() == 0) return 2; // no pay account
        Account account = accountList.get(0);
        // update account money
        accountService.updateAccountMoneyById(account.getId(), orderForm.getMoney(), 1);
        // check storage
        int res = storageService.deleteItemNumber(orderForm.getItemId(), orderForm.getStorageId(), orderForm.getItemNumber());
        if (res < 0) return -1;
        // prepare form
        RetailOrder retailOrder = new RetailOrder();
        retailOrder.setMoney(orderForm.getMoney());
        retailOrder.setTradeTime(new Date());
        retailOrder.setItemId(orderForm.getItemId());
        retailOrder.setItemNumber(orderForm.getItemNumber());
        retailOrder.setStorageId(orderForm.getStorageId());
        retailOrder.setUserId(orderForm.getUserId());
        retailOrder.setRemark(orderForm.getRemark());
        retailOrder.setMemberId(orderForm.getMemberId());
        retailOrder.setAccountId(account.getId());

        res = retailOrderService.addRetailOrder(retailOrder);
        if (res <= 0) return 3;
        return 1;
    }
}
