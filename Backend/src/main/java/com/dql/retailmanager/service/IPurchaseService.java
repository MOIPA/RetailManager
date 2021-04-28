package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.Purchase;
import com.dql.retailmanager.entity.form.SearchForm;
import org.springframework.stereotype.Service;

@Service
public interface IPurchaseService {

    int deleteByTicketCode(String ticketCode);

    Object listOrderByPage(SearchForm pageRequest);

    Object listSellOrderByPage(SearchForm pageRequest);

    int addOrder(Purchase orderForm);
}
