package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.page.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface IItemService {
    int deleteById(Integer id);

    int addItem(Item record);

    int insertSelective(Item record);

    Item getItemById(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateById(Item record);

    Object listItemByPage(SearchForm pageRequest);
}
