package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.RetailOrder;
import com.dql.retailmanager.entity.RetailOrder;
import com.dql.retailmanager.entity.form.SearchForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IRetailOrderService {
    int deleteById(String code);

    int addRetailOrder(RetailOrder record);

    int insertSelective(RetailOrder record);

    RetailOrder getRetailOrderById(String code);

    int updateByPrimaryKeySelective(RetailOrder record);

    int updateById(RetailOrder record);

    Object listRetailOrderByPage(SearchForm pageRequest);

    Integer getTotalOrderNumbers();

    Integer getTotalTurnOver();

    Integer getHeighestTurnOver();

    Integer getTotalMemberNumbers();

    Integer getMoneyToday();

    List<Map> getMembserStatus();

    List<Integer> retailStatus(Integer x);
}
