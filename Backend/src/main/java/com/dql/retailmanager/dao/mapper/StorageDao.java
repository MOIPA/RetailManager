package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.ItemAndStorageInfo;
import com.dql.retailmanager.entity.Storage;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.page.PageRequest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.dql.retailmanager.entity.Storage
 */
public interface StorageDao {
    /**
     * @mbg.generated 2021-04-25 15:20:02
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2021-04-25 15:20:02
     */
    int insert(Storage record);

    /**
     * @mbg.generated 2021-04-25 15:20:02
     */
    int insertSelective(Storage record);

    /**
     * @mbg.generated 2021-04-25 15:20:02
     */
    Storage getStorageById(Integer id);

    /**
     * @mbg.generated 2021-04-25 15:20:02
     */
    int updateByPrimaryKeySelective(Storage record);

    /**
     * @mbg.generated 2021-04-25 15:20:02
     */
    int updateByPrimaryKey(Storage record);


    List<Storage> selectPage(PageRequest pageRequest);

    @Select("select distinct item.name,item.desc,item.id itemId,item.item_code itemCode,number,safe_number safeNumber" +
            " from item inner join item_storage on item.id = item_storage.item_id" +
            " inner join storage on storage.id = item_storage.storage_id " +
            " where storage.id = #{storageId}")
    List<ItemAndStorageInfo> getItemFromStorage(int storageId);

    @Delete("delete from item_storage where storage_id = #{storageId}")
    void deleteAllItemByStorageId(Integer storageId);

    List<ItemAndStorageInfo> selectItemByPage(SearchForm pageRequest);
}