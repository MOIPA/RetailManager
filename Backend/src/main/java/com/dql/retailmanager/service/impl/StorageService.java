package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.dao.mapper.ItemStorageDao;
import com.dql.retailmanager.dao.mapper.StorageDao;
import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.ItemStorage;
import com.dql.retailmanager.entity.Storage;
import com.dql.retailmanager.entity.page.PageRequest;
import com.dql.retailmanager.service.IStorageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StorageService implements IStorageService {
    @Resource
    StorageDao storageDao;
    @Resource
    ItemService itemService;
    @Resource
    ItemStorageDao itemStorageDao;

    @Override
    public int deleteById(Integer id) {
        return storageDao.deleteByPrimaryKey(id);
    }

    @Override
    public int addStorage(Storage record) {
        return storageDao.insert(record);
    }

    @Override
    public int insertSelective(Storage record) {
        return storageDao.insertSelective(record);
    }

    @Override
    public Storage selectByPrimaryId(Integer id) {
        return storageDao.getStorageById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Storage record) {
        return storageDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Storage record) {
        return storageDao.updateByPrimaryKey(record);
    }

    @Override
    public Object listStorageByPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public String putItemInStorage(ItemStorage record) {
        Item item = this.itemService.getItemById(record.getItemId());
        if (item == null) return "error no such item";
        Storage storage = this.storageDao.getStorageById(record.getStorageId());
        if (storage == null) return "error no such storage";
        this.itemStorageDao.insert(record);
        return "";
    }

    public PageInfo<Storage> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Storage> itemList = storageDao.selectPage(pageRequest);
        return new PageInfo<Storage>(itemList);
    }

}