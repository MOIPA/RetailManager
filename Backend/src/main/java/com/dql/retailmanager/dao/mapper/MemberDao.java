package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.Member;
import com.dql.retailmanager.entity.User;
import com.dql.retailmanager.entity.form.SearchForm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.dql.retailmanager.entity.Member
 */
public interface MemberDao {
    /**
     *
     * @mbg.generated 2021-04-23 14:38:39
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2021-04-23 14:38:39
     */
    int insert(Member record);

    /**
     *
     * @mbg.generated 2021-04-23 14:38:39
     */
    int insertSelective(Member record);

    /**
     *
     * @mbg.generated 2021-04-23 14:38:39
     */
    Member selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2021-04-23 14:38:39
     */
    int updateByPrimaryKeySelective(Member record);

    /**
     * @mbg.generated 2021-04-23 14:38:39
     */
    int updateByPrimaryKey(Member record);

    @Select("select * from member where name like concat('%',#{username},'%')")
    List<Member> selectPage(SearchForm pageRequest);

    @Select("select * from member where name = #{name} and pwd = #{pass}")
    Member selectByName(String name, String pass);

    @Select("select * from member where name = #{name}")
    Member findMemberByName(String name);
}