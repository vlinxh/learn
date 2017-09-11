package com.xhlim.springboot.service;

import com.xhlim.springboot.entity.User; /**
 * @author xhlim@outlook.com
 * @create 2017-09-10 20:21
 */
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    User saveUser(User user);
}
