package com.xhlim.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-08 16:58
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    public static final String STATE_VALID = "1";   // 有效
    public static final String STATE_INVALID = "0"; // 无效

    protected static final String timezone = "GMT+08:00"; // 东八区


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "varchar(10) COMMENT '序列号'")
    private long seq;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "com.xhlim.springboot.entity.id.UUIDGenerator")
    @Column(columnDefinition = "varchar(36) COMMENT '主键'")
    private String id;

    @Column(columnDefinition = "varchar(36) COMMENT '创建人'")
    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = timezone)
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createDate;

    @Column(columnDefinition = "varchar(36) COMMENT '修改人'")
    private String updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = timezone)
    @Column(columnDefinition = "datetime COMMENT '修改时间'")
    private Date updateDate;

    @Column(columnDefinition = "enum('1','0') COMMENT '1 有效，0 无效'")
    protected String state = STATE_VALID;

    @PrePersist
    protected void onCreate() {
        updateDate = createDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = new Date();
    }


}
