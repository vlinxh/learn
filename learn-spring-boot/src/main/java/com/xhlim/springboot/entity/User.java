package com.xhlim.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-08 15:25
 */
@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity {

    @Column(columnDefinition = "varchar(64) COMMENT '用户名'")
    private String name;

    @Column(columnDefinition = "varchar(64) COMMENT '用户密码'")
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = timezone)
    @Column(columnDefinition = "datetime COMMENT '最后登录时间'")
    private Date lastLogin;


}
