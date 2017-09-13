package com.xhlim.springboot.dao;

import com.xhlim.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-10 20:23
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Query(value = "select * from user where id = ?", nativeQuery = true)
    // @Query("select t from #{#entityName} t where t.taskName = ? and t.createTime = ?")
    User findBySQL(String id);

    @Query(value = "select new Map(id,name) from user where id = ?", nativeQuery = true)
    String findMapBySQL(String id);
}
