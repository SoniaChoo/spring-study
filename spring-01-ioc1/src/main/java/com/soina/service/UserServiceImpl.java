package com.soina.service;

import com.soina.dao.UserDao;
import com.soina.dao.UserDaoImpl;
import com.soina.dao.UserDaoMysqlImpl;
import com.soina.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService{
    //private UserDao userDao =  new UserDaoOracleImpl();
    private UserDao userDao;
    public void  setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}



