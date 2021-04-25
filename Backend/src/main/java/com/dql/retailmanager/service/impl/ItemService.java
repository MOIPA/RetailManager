package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.dao.mapper.ItemDao;
import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.Member;
import com.dql.retailmanager.entity.form.UpdateMemberForm;
import com.dql.retailmanager.entity.page.PageRequest;
import com.dql.retailmanager.service.IItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemService implements IItemService {
    @Resource
    ItemDao dao;

    @Override
    public int deleteById(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int addItem(Item record) {
        return dao.insert(record);
    }

    @Override
    public int insertSelective(Item record) {
        return dao.insertSelective(record);
    }

    @Override
    public Item selectByPrimaryId(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Item record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Item record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Object listItemByPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    public PageInfo<Item> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Item> itemList = dao.selectPage(pageRequest);
        return new PageInfo<Item>(itemList);
    }

}
