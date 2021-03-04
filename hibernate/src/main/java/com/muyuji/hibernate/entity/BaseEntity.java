package com.muyuji.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-08 16:58
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    /**
     * 有效
     */
    public static final String STATE_VALID = "1";

    /**
     * 无效
     */
    public static final String STATE_INVALID = "0";

    /**
     * 东八区
     */
    protected static final String TIME_ZONE = "GMT+08:00";


    /**
     * 序列号，自增长
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "com.muyuji.hibernate.entity.id.UUIDGenerator")
    private String id;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 状态 1 有效，0 无效
     */
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
