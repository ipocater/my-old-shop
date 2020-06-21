package com.ipoca.my.shop.service;

import com.ipoca.my.shop.entity.User;

public interface UserService {

    public User login(String email, String password);
}
