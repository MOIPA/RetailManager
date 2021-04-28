package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.dao.mapper.PurchaseDao;
import com.dql.retailmanager.entity.Purchase;
import com.dql.retailmanager.entity.PurchaseOrderVO;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.service.IPurchaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PurchaseService implements IPurchaseService {
    @Resource
    PurchaseDao dao;

    @Override
    public int deleteByTicketCode(String ticketCode) {
        return dao.deleteByTicketCode(ticketCode);
    }

    @Override
    public Object listOrderByPage(SearchForm pageRequest) {
        pageRequest.setSellOrder(0);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public Object listSellOrderByPage(SearchForm pageRequest) {
        pageRequest.setSellOrder(1);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public int addOrder(Purchase orderForm) {
        return this.dao.insert(orderForm);
    }


    public PageInfo<PurchaseOrderVO> getPageInfo(SearchForm pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<PurchaseOrderVO> itemList = dao.selectPage(pageRequest);
        return new PageInfo<PurchaseOrderVO>(itemList);
    }
}
