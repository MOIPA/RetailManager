package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.dao.mapper.StorageDao;
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
    StorageDao dao;

    @Override
    public int deleteById(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int addStorage(Storage record) {
        return dao.insert(record);
    }

    @Override
    public int insertSelective(Storage record) {
        return dao.insertSelective(record);
    }

    @Override
    public Storage selectByPrimaryId(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Storage record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Storage record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Object listStorageByPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    public PageInfo<Storage> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Storage> itemList = dao.selectPage(pageRequest);
        return new PageInfo<Storage>(itemList);
    }

}
