package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.ItemStorage;
import org.apache.ibatis.annotations.Delete;

/**
 * @Entity com.dql.retailmanager.entity.ItemStorage
 */
public interface ItemStorageDao {
    /**
     * @mbg.generated 2021-04-25 15:19:24
     */
    int insert(ItemStorage record);

    /**
     * @mbg.generated 2021-04-25 15:19:24
     */
    int insertSelective(ItemStorage record);

    @Delete("delete from item_storage where item_id=#{itemId} and storage_id = #{storageId}")
    void deleteItemFromStorage(int itemId, int storageId);
}