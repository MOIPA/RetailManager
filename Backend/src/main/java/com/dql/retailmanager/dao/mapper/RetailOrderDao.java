package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.RetailOrder;
import com.dql.retailmanager.entity.RetailOrderVO;
import com.dql.retailmanager.entity.form.SearchForm;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    @Select("select count(*) from retail_order")
    Integer getTotalOrderNumbers();

    @Select("select sum(money) from retail_order")
    Integer getTotalTurnOver();

    @Select("select max(money) from retail_order")
    Integer getHeighestTurnOver();

    @Select("select count(*) from member")
    Integer getTotalMemberNumbers();

    @Select("select sum(money) from retail_order where DATEDIFF(trade_time,NOW())=0")
    Integer getMoneyToday();

    List<Map> getMemberStatus();

    List<Integer> getRetailStatus(Integer x);

    List<Map> getAccountStatus();

    List<Integer> getPurchaseStatus(Integer x);
}