package com.xhlim.springboot.dao;

import com.xhlim.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-10 20:23
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {
}
