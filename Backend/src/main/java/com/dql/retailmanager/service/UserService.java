package com.dql.retailmanager.service;

import com.dql.retailmanager.dao.mapper.UserDao;
import com.dql.retailmanager.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserDao userDao;

    /**
     * select user by primary key
     * @param id
     * @return
     */
    public User findUserById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * add new user to db
     * @param user
     * @return
     */
    public int createUser(User user) {
        return userDao.insert(user);
    }

    /**
     * delete a user by primary key
     * @param id
     * @return
     */
    public int deleteUserById(int id) {
        return userDao.deleteByPrimaryKey(id);
    }

    /**
     * update user
     * @param user
     * @return
     */
    public int updateUser(User user) {
        return userDao.updateByPrimaryKey(user);
    }

    public User findUserByName(String name) {
        return userDao.selectByName(name);
    }
}
