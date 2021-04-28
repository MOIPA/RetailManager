package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.RetailOrder;
import com.dql.retailmanager.entity.RetailOrderVO;
import com.dql.retailmanager.entity.form.SearchForm;

import java.util.List;

/**
 * @Entity com.dql.retailmanager.entity.RetailOrder
 */
public interface RetailOrderDao {
    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    int deleteByPrimaryKey(String retailCode);

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    int insert(RetailOrder record);

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    int insertSelective(RetailOrder record);

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    RetailOrder selectByPrimaryKey(String retailCode);

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    int updateByPrimaryKeySelective(RetailOrder record);

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    int updateByPrimaryKey(RetailOrder record);

    List<RetailOrderVO> selectPage(SearchForm pageRequest);
}