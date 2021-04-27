package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.Account;
import com.dql.retailmanager.entity.form.SearchForm;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {
    int deleteById(Integer id);

    int addAccount(Account record);

    int insertSelective(Account record);

    Account getAccountById(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateById(Account record);

    Object listAccountByPage(SearchForm pageRequest);

    int activeAccount(int id);
}
