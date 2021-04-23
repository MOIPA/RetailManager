package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.Member;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
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
     *
     * @mbg.generated 2021-04-23 14:38:39
     */
    int updateByPrimaryKey(Member record);

    @Select("select * from member")
    List<Member> selectPage();

}