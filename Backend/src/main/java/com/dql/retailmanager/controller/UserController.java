package com.dql.retailmanager.controller;

import com.dql.retailmanager.dao.mapper.SessionDao;
import com.dql.retailmanager.entity.User;
import com.dql.retailmanager.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin
public class UserController {
    @Resource
    IUserService userService;
    @Resource
    SessionDao sessionDao;

    @GetMapping("/login")
    public User getUserById(@RequestParam String name,@RequestParam String pwd,@RequestParam String sessionToken) {
        User user = userService.findUserByName(name);
        if (user!=null && user.getPwd().equals(pwd.trim())){
            // 存储用户session
            sessionDao.deleteSessionByUserId(user.getId());
            sessionDao.insertSession(user.getId(), sessionToken);
            return user;
        }
        return null;
    }
    @GetMapping("/getUserById")
    public User getUserById(@RequestParam int id) {
        return userService.findUserById(id);
    }

    @GetMapping("/getUserByName")
    public User getUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/deleteUserById")
    public int deleteUserById(@RequestParam int id) {
        return userService.deleteUserById(id);
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/updateUser")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
