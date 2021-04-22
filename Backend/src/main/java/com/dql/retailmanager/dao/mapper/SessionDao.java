package com.dql.retailmanager.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SessionDao {
    @Insert("insert into user_session(user_id,sessionid)value(#{userId},#{sessionToken})")
    int insertSession(int userId, String sessionToken);

    @Select("select sessionid from user_session where user_id = #{userId}")
    String getSessionByUserId(int userId);

    @Delete("delete from user_session where user_id = #{userId}")
    int deleteSessionByUserId(int userId);
}
