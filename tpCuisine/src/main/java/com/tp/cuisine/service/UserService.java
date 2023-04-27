package com.tp.cuisine.service;

import com.tp.cuisine.dao.UserDao;
import com.tp.cuisine.model.User;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }


}
