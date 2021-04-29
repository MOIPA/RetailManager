package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.ItemAndStorageInfo;
import com.dql.retailmanager.entity.ItemStorage;
import com.dql.retailmanager.entity.Storage;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.form.StorageItemForm;
import com.dql.retailmanager.entity.ItemAndInventoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStorageService {
    int deleteById(Integer id);

    int addStorage(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryId(Integer id);

    int updateByPrimaryKeySelective(Storage record);

    int updateById(Storage record);

    Object listStorageByPage(SearchForm pageRequest);

    String putItemInStorage(ItemStorage record);

    List<ItemAndStorageInfo> getItemFromStorage(int storageId);

    void deleteAllItem(Integer storageId);

    Object getItemFromStorageByPage(SearchForm pageRequest);

    int deleteItemFromStorage(int[] itemIds, int storageId);

    int updateItemNumber(Integer itemId, Integer storageId, Integer number);

    int updateIntemInfo(StorageItemForm form);

    int deleteItemNumber(int itemId, int storageId, int number);

    List<ItemAndInventoryVO> itemListAndinventory(int pageRequest);
}
