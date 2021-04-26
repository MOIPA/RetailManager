package com.dql.retailmanager.service;

import com.dql.retailmanager.dao.mapper.UserDao;
import com.dql.retailmanager.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface IUserService {

    /**
     * select user by primary key
     *
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * add new user to db
     *
     * @param user
     * @return
     */
    int createUser(User user);

    /**
     * delete a user by primary key
     *
     * @param id
     * @return
     */
    int deleteUserById(int id);

    /**
     * update user
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    User findUserByName(String name);

    List<String> getUserAuthorityById(int userId);

    int checkAuthority(int userId, String auth);
}
