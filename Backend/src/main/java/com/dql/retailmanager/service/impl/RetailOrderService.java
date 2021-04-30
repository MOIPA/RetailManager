package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.Utils.Uuid;
import com.dql.retailmanager.dao.mapper.RetailOrderDao;
import com.dql.retailmanager.entity.RetailOrder;
import com.dql.retailmanager.entity.RetailOrderVO;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.service.IRetailOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author dql
 */
@Service
public class RetailOrderService implements IRetailOrderService {
    @Resource
    RetailOrderDao dao;

    @Override
    public int deleteById(String code) {
        return dao.deleteByPrimaryKey(code);
    }

    @Override
    public int addRetailOrder(RetailOrder record) {
        record.setTradeTime(new Date());
        record.setRetailCode(Uuid.generateUUID());
        return dao.insert(record);
    }

    @Override
    public int insertSelective(RetailOrder record) {
        return dao.insertSelective(record);
    }

    @Override
    public RetailOrder getRetailOrderById(String code) {
        return dao.selectByPrimaryKey(code);
    }

    @Override
    public int updateByPrimaryKeySelective(RetailOrder record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(RetailOrder record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Object listRetailOrderByPage(SearchForm pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public Integer getTotalOrderNumbers() {
        return dao.getTotalOrderNumbers();
    }

    @Override
    public Integer getTotalTurnOver() {
        return dao.getTotalTurnOver();
    }

    @Override
    public Integer getHeighestTurnOver() {
        return dao.getHeighestTurnOver();
    }

    @Override
    public Integer getTotalMemberNumbers() {
        return dao.getTotalMemberNumbers();
    }

    @Override
    public Integer getMoneyToday() {
        return dao.getMoneyToday();
    }

    @Override
    public List<Map> getMembserStatus() {
        return dao.getMemberStatus();
    }

    @Override
    public List<Integer> retailStatus(Integer x) {
        return dao.getRetailStatus(x);
    }

    public PageInfo<RetailOrderVO> getPageInfo(SearchForm pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<RetailOrderVO> itemList = dao.selectPage(pageRequest);
        return new PageInfo<RetailOrderVO>(itemList);
    }

}
