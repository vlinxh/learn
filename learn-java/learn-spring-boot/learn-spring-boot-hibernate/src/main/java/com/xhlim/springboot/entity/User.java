package com.xhlim.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-08 15:25
 */
@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = TIME_ZONE)
    private Date lastLogin;


}
