package com.muyuji.hibernate.service.impl;

import com.muyuji.hibernate.dao.UserDao;
import com.muyuji.hibernate.entity.User;
import com.muyuji.hibernate.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-10 20:22
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User findUser(String id) {
        User user = userDao.findBySQL(id);
        log.debug("通过SQL查询结果:{}", user);
        user = userDao.findById(id).orElseGet(null);
        log.debug("通过hibernate查询结果:{}", user);
        return user;
    }
}
