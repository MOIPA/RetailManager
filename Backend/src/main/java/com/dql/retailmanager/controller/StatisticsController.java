package com.dql.retailmanager.controller;

import com.dql.retailmanager.service.IMemberService;
import com.dql.retailmanager.service.IRetailOrderService;
import com.dql.retailmanager.service.IStorageService;
import com.dql.retailmanager.service.impl.ItemService;
import com.dql.retailmanager.service.impl.RetailOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Resource
    private ItemService itemService;
    @Resource
    private IRetailOrderService retailOrderService;
    @Resource
    private IMemberService memberService;
    @Resource
    private IStorageService storageService;

    @GetMapping("/totalNumberStatus")
    public Integer[] getTotalNumberStatus() {
        Integer[] res = new Integer[6];
        // total item numbers
        res[0] = storageService.getStorageItemNumbers();
        // total order numbers
        res[1] = retailOrderService.getTotalOrderNumbers();
        // total turnover
        res[2] = retailOrderService.getTotalTurnOver();
        // heighest turnover
        res[3] = retailOrderService.getHeighestTurnOver();
        // member numbers
        res[4] = retailOrderService.getTotalMemberNumbers();
        // money earned today
        res[5] = retailOrderService.getMoneyToday();
        return res;
    }
}
