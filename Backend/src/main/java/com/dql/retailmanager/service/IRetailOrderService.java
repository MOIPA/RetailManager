package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.RetailOrder;
import com.dql.retailmanager.entity.RetailOrder;
import com.dql.retailmanager.entity.form.SearchForm;
import org.springframework.stereotype.Service;

@Service
public interface IRetailOrderService {
    int deleteById(String code);

    int addRetailOrder(RetailOrder record);

    int insertSelective(RetailOrder record);

    RetailOrder getRetailOrderById(String code);

    int updateByPrimaryKeySelective(RetailOrder record);

    int updateById(RetailOrder record);

    Object listRetailOrderByPage(SearchForm pageRequest);
}
