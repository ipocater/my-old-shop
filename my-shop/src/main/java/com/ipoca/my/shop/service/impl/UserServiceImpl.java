package com.ipoca.my.shop.service.impl;

import com.ipoca.my.shop.commons.context.SpringContext;
import com.ipoca.my.shop.dao.UserDao;
import com.ipoca.my.shop.entity.User;
import com.ipoca.my.shop.service.UserService;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao = SpringContext.getBean("userDao");

    public User login(String email, String password) {
        return userDao.getUser(email,password);
    }
}
