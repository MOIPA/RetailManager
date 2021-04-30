package com.dql.retailmanager.controller;

import com.dql.retailmanager.service.IMemberService;
import com.dql.retailmanager.service.IRetailOrderService;
import com.dql.retailmanager.service.IStorageService;
import com.dql.retailmanager.service.impl.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @GetMapping("/memberStatus")
    public long[] memberStatus() {
        List<Map> membserStatus = retailOrderService.getMembserStatus();
        long[] numbers = membserStatus.stream().mapToLong(x -> {
            Object addNumbers = x.get("addNumbers");
            if (addNumbers == null) return 0;
            else return (long) addNumbers;
        }).toArray();
        return numbers;
    }

    @GetMapping("/retailStatus")
    public List<Map> retailStatus() {
        List<Map> result = new LinkedList<>();
        Map res = new HashMap();
        List<Map> storageIds = storageService.getAllStorage();
        for (int i = 0; i < storageIds.size(); i++) {
            Map x = storageIds.get(i);
            List<Integer> membserStatus = retailOrderService.retailStatus((Integer) x.get("id"));
            res.put("name", x.get("name"));
            res.put("data", membserStatus.stream().map(y -> y == null ? 0 : y).collect(Collectors.toList()));
            res.put("type", "line");
            res.put("smooth", true);
            Map tmp = new HashMap();
            Map tmpx = new HashMap();
            tmp.put("normal", tmpx);
            res.put("areaStyle", tmp);
            result.add(res);
            res = new HashMap();
        }
        return result;
    }
}
