package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.dao.mapper.AccountDao;
import com.dql.retailmanager.entity.Account;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.service.IAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Resource
    AccountDao dao;

    @Override
    public int deleteById(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int addAccount(Account record) {
        if (record.getActive() == 1) {
            List<Account> activedAccount = dao.getActivedAccount();
            if (activedAccount != null && activedAccount.size() > 0) return -2;
        }
        return dao.insert(record);
    }

    @Override
    public int insertSelective(Account record) {
        return dao.insertSelective(record);
    }

    @Override
    public Account getAccountById(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Account record) {
        if (record.getActive() == 1) {
            List<Account> activedAccount = dao.getActivedAccount();
            if (activedAccount != null && activedAccount.size() > 0
                    && !activedAccount.get(0).getId().equals(record.getId()))
                return -2;
        }
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Object listAccountByPage(SearchForm pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public int activeAccount(int id) {
        List<Account> accounts = dao.getActivedAccount();
        if (accounts == null || accounts.size() == 0) {
            return dao.activeAccount(id);
        }
        // -2 : exist activited account
        return -2;
    }

    @Override
    public List<Account> getActivitedAccount() {
        return dao.getActivedAccount();
    }

    @Override
    public double updateAccountMoneyById(Integer accountId, Integer totalMoney, int isPlus) {
        Account account = dao.selectByPrimaryKey(accountId);
        double v;
        if (isPlus == 1) {
            v = account.getCurrentMoney() + totalMoney;
        } else {
            v = account.getCurrentMoney() - totalMoney;
        }
        if (v < 0) return v;
        account.setCurrentMoney(v);
        return dao.updateByPrimaryKey(account);
    }

    public PageInfo<Account> getPageInfo(SearchForm pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Account> itemList = dao.selectPage(pageRequest);
        return new PageInfo<Account>(itemList);
    }

}
