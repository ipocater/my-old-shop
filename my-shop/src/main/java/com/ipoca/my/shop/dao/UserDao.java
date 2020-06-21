package com.ipoca.my.shop.dao;

import com.ipoca.my.shop.entity.User;

public interface UserDao {
    /**
     * 根据邮箱和密码获取用户信息
     * @param email
     * @param password
     * @return 用户
     */
    public User getUser(String email, String password);
}
