package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.dao.mapper.UserDao;
import com.dql.retailmanager.entity.User;
import com.dql.retailmanager.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Resource
    UserDao userDao;

    /**
     * select user by primary key
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * add new user to db
     *
     * @param user
     * @return
     */
    @Override
    public int createUser(User user) {
        return userDao.insert(user);
    }

    /**
     * delete a user by primary key
     *
     * @param id
     * @return
     */
    @Override
    public int deleteUserById(int id) {
        return userDao.deleteByPrimaryKey(id);
    }

    /**
     * update user
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return userDao.updateByPrimaryKey(user);
    }

    @Override
    public User findUserByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public List<String> getUserAuthorityById(int userId) {
        return userDao.getUserAuthorityById(userId);
    }

    @Override
    public int checkAuthority(int userId, String auth) {
        List<String> userAuthorityById = userDao.getUserAuthorityById(userId);
        if (userAuthorityById.stream().filter(x -> x.equals(auth)).count() > 0)
            return 1;
        return -1;
    }
}
