package com.muyuji.hibernate.dao;

import com.muyuji.hibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-10 20:23
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {

    /**
     * 根据id查询用户信息，自定义sql返回用户对象
     *
     * @param id
     * @return
     */
    @Query(value = "select * from t_user where id = ?", nativeQuery = true)
    User findBySQL(String id);

}
