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
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public String addSellingOrder(@RequestBody RetailOrderForm orderForm) {
        // check default account
        List<Account> accountList = accountService.getActivitedAccount();
        // check storage
        int res = 0;
        if (orderForm.getItemList() == null || orderForm.getItemList().size() == 0) return "f : no item";
        for (Item x : orderForm.getItemList()) {
            if (storageService.deleteItemNumber(x.getId(), orderForm.getStorageId(), Integer.parseInt(x.getNumber())) <= 0) {
                return "f : " + x.getName() + " is not enough";
            }
        }
        // -2 no pay account
        if (accountList == null || accountList.size() == 0) return "f : no active account"; // no pay account
        Account account = accountList.get(0);

        // prepare form
        RetailOrder retailOrder = new RetailOrder();
        retailOrder.setMoney(orderForm.getMoney());
        retailOrder.setTradeTime(new Date());
        retailOrder.setItemId(StringUtils.join(orderForm.getItemList().stream().map(x -> String.valueOf(x.getId())).collect(Collectors.toList()), ','));
        retailOrder.setItemNumber(orderForm.getItemList().stream().mapToInt(x -> Integer.parseInt(x.getNumber())).sum());
        retailOrder.setStorageId(orderForm.getStorageId());
        retailOrder.setUserId(orderForm.getUserId());
        retailOrder.setRemark(orderForm.getRemark());
        retailOrder.setMemberId(orderForm.getMemberId());
        retailOrder.setAccountId(account.getId());
        retailOrder.setRetailCode(Uuid.generateUUID());
        res = retailOrderService.addRetailOrder(retailOrder);
        if (res <= 0) return "f : add retail order failed";

        // update account money
        accountService.updateAccountMoneyById(account.getId(), orderForm.getMoney(), 1);

        return "s : add retail order succeed";
    }
}
