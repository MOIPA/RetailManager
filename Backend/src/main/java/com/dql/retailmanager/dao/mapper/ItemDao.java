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

    @Select("select id,name,price,`desc`,item_code as itemCode,pic_id picId from item where name like concat('%',#{itemname},'%')")
    List<Item> selectPage(SearchForm pageRequest);

    @Select("select * from item where name = #{name}")
    List<Item> getItemByName(String name);

    @Select("select pic_id from item where id = #{id}")
    int getItemPicById(int id);
}