package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.ItemPic;

/**
 * @Entity com.dql.retailmanager.entity.ItemPic
 */
public interface ItemPicDao {
    /**
     * @mbg.generated 2021-05-06 10:45:44
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2021-05-06 10:45:44
     */
    int insert(ItemPic record);

    /**
     * @mbg.generated 2021-05-06 10:45:44
     */
    int insertSelective(ItemPic record);

    /**
     * @mbg.generated 2021-05-06 10:45:44
     */
    ItemPic selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2021-05-06 10:45:44
     */
    int updateByPrimaryKeySelective(ItemPic record);

    /**
     * @mbg.generated 2021-05-06 10:45:44
     */
    int updateByPrimaryKeyWithBLOBs(ItemPic record);
}