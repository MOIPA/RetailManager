package com.dql.retailmanager.controller;

import com.dql.retailmanager.dao.mapper.SessionDao;
import com.dql.retailmanager.dao.mapper.UserDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Resource
    UserDao userDao;
    @Resource
    SessionDao sessionDao;

    @GetMapping("/check")
    public int checkSession(String userId, String token) {
        try {
            String sessionByUserId = sessionDao.getSessionByUserId(Integer.parseInt(userId));
            if (sessionByUserId != null && sessionByUserId.equals(token)) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
