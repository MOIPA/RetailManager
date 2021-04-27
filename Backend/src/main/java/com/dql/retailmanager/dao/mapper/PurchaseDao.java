package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.Purchase;

/**
 * @Entity com.dql.retailmanager.entity.Purchase
 */
public interface PurchaseDao {
    /**
     * @mbg.generated 2021-04-27 14:58:45
     */
    int insert(Purchase record);

    /**
     * @mbg.generated 2021-04-27 14:58:45
     */
    int insertSelective(Purchase record);
}