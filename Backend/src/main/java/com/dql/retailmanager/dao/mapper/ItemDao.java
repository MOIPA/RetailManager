package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.Item;

/**
 * @Entity com.dql.retailmanager.entity.Item
 */
public interface ItemDao {
    /**
     * @mbg.generated 2021-04-25 15:19:09
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2021-04-25 15:19:09
     */
    int insert(Item record);

    /**
     * @mbg.generated 2021-04-25 15:19:09
     */
    int insertSelective(Item record);

    /**
     * @mbg.generated 2021-04-25 15:19:09
     */
    Item selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2021-04-25 15:19:09
     */
    int updateByPrimaryKeySelective(Item record);

    /**
     * @mbg.generated 2021-04-25 15:19:09
     */
    int updateByPrimaryKey(Item record);
}