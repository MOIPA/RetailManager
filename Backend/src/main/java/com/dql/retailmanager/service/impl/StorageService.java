package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.dao.mapper.ItemStorageDao;
import com.dql.retailmanager.dao.mapper.StorageDao;
import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.ItemAndStorageInfo;
import com.dql.retailmanager.entity.ItemStorage;
import com.dql.retailmanager.entity.Storage;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.form.StorageItemForm;
import com.dql.retailmanager.service.IStorageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public Object listStorageByPage(SearchForm pageRequest) {
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

    @Override
    public List<ItemAndStorageInfo> getItemFromStorage(int storageId) {
        return storageDao.getItemFromStorage(storageId);
    }

    @Override
    public void deleteAllItem(Integer storageId) {
        storageDao.deleteAllItemByStorageId(storageId);
    }

    @Override
    public Object getItemFromStorageByPage(SearchForm pageRequest) {
        return PageUtils.getPageResult(pageRequest, getItemPageInfo(pageRequest));
    }

    @Override
    public int deleteItemFromStorage(int[] itemIds, int storageId) {
        for (int itemId : itemIds) {
            this.itemStorageDao.deleteItemFromStorage(itemId, storageId);
        }
        return 0;
    }

    @Override
    public int updateItemNumber(Integer itemId, Integer storageId, Integer number) {
        ItemStorage itemStorage = this.itemStorageDao.getItem(itemId, storageId);
        if (itemStorage == null) {
            ItemStorage itemStorage1 = new ItemStorage();
            itemStorage1.setItemId(itemId);
            itemStorage1.setStorageId(storageId);
            itemStorage1.setNumber(number);
            itemStorage1.setSafeNumber(0);
            itemStorage1.setUpdateTime(new Date());
            return itemStorageDao.insert(itemStorage1);
        }
        return this.itemStorageDao.updateItemNumber(itemId, storageId, number + itemStorage.getNumber());
    }

    @Override
    public int updateIntemInfo(StorageItemForm form) {
        return itemStorageDao.updateItemNumberAndSafeNumber(form);
    }

    public PageInfo<Storage> getPageInfo(SearchForm pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Storage> itemList = storageDao.selectPage(pageRequest);
        return new PageInfo<Storage>(itemList);
    }


    public PageInfo<ItemAndStorageInfo> getItemPageInfo(SearchForm pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<ItemAndStorageInfo> itemList = storageDao.selectItemByPage(pageRequest);
        return new PageInfo<ItemAndStorageInfo>(itemList);
    }

}
