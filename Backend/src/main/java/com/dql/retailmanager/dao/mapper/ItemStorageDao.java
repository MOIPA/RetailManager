package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.ItemStorage;
import com.dql.retailmanager.entity.form.StorageItemForm;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Update("update item_storage set number = #{number} where item_id = #{itemId} and storage_id = #{storageId}")
    int updateItemNumber(Integer itemId, Integer storageId, Integer number);

    @Select("select number from item_storage where item_id = #{itemId} and storage_id = #{storageId}")
    int getItemNumber(Integer itemId, Integer storageId);

    @Select("select * from item_storage where item_id = #{itemId} and storage_id = #{storageId}")
    ItemStorage getItem(Integer itemId, Integer storageId);

    @Update("update item_storage set number=#{number},safe_number=#{safeNumber} where item_id=#{itemId} and storage_id=#{storageId}")
    int updateItemNumberAndSafeNumber(StorageItemForm form);
}