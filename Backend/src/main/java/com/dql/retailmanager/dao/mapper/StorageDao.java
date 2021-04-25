package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.Storage;
import com.dql.retailmanager.entity.page.PageRequest;
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

    @Select("select * from storage")
    List<Storage> selectPage(PageRequest pageRequest);
}