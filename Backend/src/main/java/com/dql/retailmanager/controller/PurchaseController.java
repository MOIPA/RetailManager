package com.dql.retailmanager.controller;

import com.dql.retailmanager.Utils.Uuid;
import com.dql.retailmanager.entity.Account;
import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.Purchase;
import com.dql.retailmanager.entity.form.OrderForm;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.service.IAccountService;
import com.dql.retailmanager.service.IItemService;
import com.dql.retailmanager.service.IPurchaseService;
import com.dql.retailmanager.service.IStorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/purchase")
@CrossOrigin
public class PurchaseController {
    @Resource
    IPurchaseService purchaseService;
    @Resource
    IItemService itemService;
    @Resource
    IAccountService accountService;
    @Resource
    IStorageService storageService;

    @GetMapping("/deleteByTicketCode")
    public int deleteByTicketCode(@RequestParam List<String> code) {
        try {
            int i = code.stream().mapToInt(x -> purchaseService.deleteByTicketCode(x)).sum();
            if (i <= 0) return -1;
        } catch (Exception e) {
            return -2;
        }
        return 1;
    }

    @PostMapping("/listOrderByPage")
    public Object listOrderByPage(@RequestBody SearchForm searchForm) {
        return purchaseService.listOrderByPage(searchForm);
    }

    @PostMapping("/listSellOrderByPage")
    public Object listSellOrderByPage(@RequestBody SearchForm searchForm) {
        return purchaseService.listSellOrderByPage(searchForm);
    }

    @PostMapping("/addOrder")
    public int addOrder(@RequestBody OrderForm orderForm) {
        // check default account
        List<Account> accountList = accountService.getActivitedAccount();
        // -2 no pay account
        if (accountList == null || accountList.size() == 0) return 2; // no pay account
        Account account = accountList.get(0);
        Item itemById = itemService.getItemById(orderForm.getItemId());
        int res = (int) accountService.updateAccountMoneyById(account.getId(), itemById.getPrice() * orderForm.getNumber(), 0);
        if (res < 0) return res; // not enough money
        // prepare form
        Purchase purchase = new Purchase();
        purchase.setTotalMoney(itemById.getPrice() * orderForm.getNumber());
        purchase.setAccountId(account.getId());
        purchase.setNumber(orderForm.getNumber());
        purchase.setSupplier(orderForm.getSupplier());
        purchase.setTicketCode(Uuid.generateUUID());
        purchase.setItemId(orderForm.getItemId());
        purchase.setUserId(orderForm.getUserId());
        purchase.setTicketDate(new Date());
        purchase.setStorageId(orderForm.getStorageId());
        purchase.setSellOrder(0);
        res = purchaseService.addOrder(purchase);
        if (res <= 0) return 3;
        // update storage
        storageService.updateItemNumber(purchase.getItemId(), purchase.getStorageId(), purchase.getNumber());
        return 1;
    }

    @PostMapping("/addSellingOrder")
    public int addSellingOrder(@RequestBody OrderForm orderForm) {
        // check default account
        List<Account> accountList = accountService.getActivitedAccount();
        // -2 no pay account
        if (accountList == null || accountList.size() == 0) return 2; // no pay account
        Account account = accountList.get(0);
        Item itemById = itemService.getItemById(orderForm.getItemId());
        // update account money
        accountService.updateAccountMoneyById(account.getId(), itemById.getPrice() * orderForm.getNumber(), 1);
        // check storage
        int res = storageService.deleteItemNumber(orderForm.getItemId(), orderForm.getStorageId(), orderForm.getNumber());
        if (res < 0) return -1;
        // prepare form
        Purchase purchase = new Purchase();
        purchase.setTotalMoney(itemById.getPrice() * orderForm.getNumber());
        purchase.setAccountId(account.getId());
        purchase.setNumber(orderForm.getNumber());
        purchase.setSupplier(orderForm.getSupplier());
        purchase.setTicketCode(Uuid.generateUUID());
        purchase.setItemId(orderForm.getItemId());
        purchase.setUserId(orderForm.getUserId());
        purchase.setTicketDate(new Date());
        purchase.setStorageId(orderForm.getStorageId());
        purchase.setSellOrder(1);
        res = purchaseService.addOrder(purchase);
        if (res <= 0) return 3;
        return 1;
    }
}
