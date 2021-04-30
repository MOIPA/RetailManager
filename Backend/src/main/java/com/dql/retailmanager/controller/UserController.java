package com.dql.retailmanager.controller;

import com.dql.retailmanager.dao.mapper.SessionDao;
import com.dql.retailmanager.entity.RoleVO;
import com.dql.retailmanager.entity.User;
import com.dql.retailmanager.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin
public class UserController {
    @Resource
    IUserService userService;
    @Resource
    SessionDao sessionDao;

    @GetMapping("/login")
    public User getUserById(@RequestParam String name, @RequestParam String pwd, @RequestParam String sessionToken) {
        User user = userService.findUserByName(name);
        if (user != null && user.getPwd().equals(pwd.trim())) {
            // 存储用户session
            sessionDao.deleteSessionByUserId(user.getId());
            sessionDao.insertSession(user.getId(), sessionToken);
            return user;
        }
        return null;
    }

    @GetMapping("/getAuthorityByUserId")
    public List<String> getUserAuthority(@RequestParam int userId) {
        return userService.getUserAuthorityById(userId);
    }

    @GetMapping("/checkAuthority")
    public int checkAuthority(@RequestParam int userId, @RequestParam String auth) {
        return userService.checkAuthority(userId, auth);
    }

    @GetMapping("/roleList")
    public List<RoleVO> roleList() {
        return userService.roleList();
    }

    @GetMapping("/getUserById")
    public User getUserById(@RequestParam int id) {
        return userService.findUserById(id);
    }

    @GetMapping("/getAllUsers")
    public Object getAllUsers() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("data", userService.getAllUsers());
        return map;
    }

    @GetMapping("/updateUserAuthority")
    public int updateUserAuthority(@RequestParam int auth, @RequestParam int userId) {
        return userService.updateUserAuthority(auth, userId);
    }

    @GetMapping("/getUserByName")
    public User getUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/deleteUserByIds")
    public int deleteUserByIds(@RequestParam int[] ids) {
        for (int id : ids) {
            userService.deleteUserById(id);
        }
        return ids.length;
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
