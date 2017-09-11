package com.xhlim.springboot.service.impl;

import com.xhlim.springboot.dao.UserDao;
import com.xhlim.springboot.entity.User;
import com.xhlim.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-10 20:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }
}
