package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Entity com.dql.retailmanager.entity.User
 */
@Mapper
public interface UserDao {
    /**
     *
     * @mbg.generated 2021-04-22 11:16:12
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2021-04-22 11:16:12
     */
    int insert(User record);

    /**
     *
     * @mbg.generated 2021-04-22 11:16:12
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated 2021-04-22 11:16:12
     */
    User selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2021-04-22 11:16:12
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated 2021-04-22 11:16:12
     */
    int updateByPrimaryKey(User record);

    @Select("select * from User where name=#{name}")
    User selectByName(@Param("name") String name);
}