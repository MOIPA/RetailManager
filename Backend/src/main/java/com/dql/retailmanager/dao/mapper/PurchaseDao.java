package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.Purchase;
import com.dql.retailmanager.entity.PurchaseOrderVO;
import com.dql.retailmanager.entity.form.SearchForm;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

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

    @Delete("delete from purchase where ticket_code=#{ticketCode}")
    int deleteByTicketCode(String ticketCode);

    List<PurchaseOrderVO> selectPage(SearchForm pageRequest);
}