package com.dql.retailmanager.controller;

import com.dql.retailmanager.entity.User;
import com.dql.retailmanager.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
//@CrossOrigin
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/login")
    public int getUserById(@RequestParam String name,@RequestParam String pwd) {
        User user = userService.findUserByName(name);
        if (user!=null && user.getPwd().equals(pwd.trim())) return 1;
        return -1;
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
