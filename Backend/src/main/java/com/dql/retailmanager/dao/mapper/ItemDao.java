package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.page.PageRequest;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("select id,name,`desc`,item_code as itemCode from item where name like concat('%',#{itemname},'%')")
    List<Item> selectPage(SearchForm pageRequest);
}