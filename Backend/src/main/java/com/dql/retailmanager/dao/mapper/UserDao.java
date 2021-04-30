package com.dql.retailmanager.dao.mapper;

import com.dql.retailmanager.entity.RoleVO;
import com.dql.retailmanager.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Entity com.dql.retailmanager.entity.User
 */
@Mapper
public interface UserDao {
    /**
     * @mbg.generated 2021-04-22 11:16:12
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2021-04-22 11:16:12
     */
    int insert(User record);

    /**
     * @mbg.generated 2021-04-22 11:16:12
     */
    int insertSelective(User record);

    /**
     * @mbg.generated 2021-04-22 11:16:12
     */
    User selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2021-04-22 11:16:12
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * @mbg.generated 2021-04-22 11:16:12
     */
    int updateByPrimaryKey(User record);

    @Select("select * from User where name=#{name}")
    User selectByName(@Param("name") String name);

    List<String> getUserAuthorityById(int userId);

    @Select("select usr.*,role.name roleName,usr.role_id roleId from User usr inner join role on role.id = usr.role_id")
    List<User> getAllUsers();

    @Select("select * from role")
    List<RoleVO> roleList();

    @Update("update User set role_id = #{auth} where id=#{userId}")
    int updateUserAuthority(int auth, int userId);
}