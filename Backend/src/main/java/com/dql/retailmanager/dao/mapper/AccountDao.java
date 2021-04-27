package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.Account;
import com.dql.retailmanager.entity.form.SearchForm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.dql.retailmanager.entity.Account
 */
public interface AccountDao {
    /**
     * @mbg.generated 2021-04-27 15:11:36
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2021-04-27 15:11:36
     */
    int insert(Account record);

    /**
     * @mbg.generated 2021-04-27 15:11:36
     */
    int insertSelective(Account record);

    /**
     * @mbg.generated 2021-04-27 15:11:36
     */
    Account selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2021-04-27 15:11:36
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * @mbg.generated 2021-04-27 15:11:36
     */
    int updateByPrimaryKey(Account record);

    @Select("select id,bank_name bankName,code ,initial_money initialMoney,current_money currentMoney,remark,active from account where bank_name like concat('%',#{bankname},'%') ")
    List<Account> selectPage(SearchForm pageRequest);

    @Select("update account set active=1 where id = #{id}")
    int activeAccount(int id);

    @Select("select * from account where active=1")
    List<Account> getActivedAccount();
}