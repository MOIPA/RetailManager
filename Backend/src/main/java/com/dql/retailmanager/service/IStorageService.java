package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.ItemStorage;
import com.dql.retailmanager.entity.Storage;
import com.dql.retailmanager.entity.page.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface IStorageService {
    int deleteById(Integer id);

    int addStorage(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryId(Integer id);

    int updateByPrimaryKeySelective(Storage record);

    int updateById(Storage record);

    Object listStorageByPage(PageRequest pageRequest);

    String putItemInStorage(ItemStorage record);
}
