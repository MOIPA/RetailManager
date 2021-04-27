package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.Purchase;
import com.dql.retailmanager.entity.form.SearchForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPurchaseService {

    List<Purchase> getAllPurchaseOrder(SearchForm pageRequest);

    Object listItemByPage(SearchForm pageRequest);
}
