package com.xhlim.comparison.entity;

import com.oracle.javafx.jmx.json.JSONException;
import lombok.Data;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by xhlim on 2017/7/6.
 */
@Data
public class SerializableEntity implements Serializable {

    // base type
    private byte b;
    private Byte by;
    private short s;
    private Short sh;
    private int i;
    private Integer in;
    private double d;
    private Double dou;
    private float f;
    private Float fl;
    private long l;
    private Long lo;
    private char c;
    private Character ch;
    private boolean bo;
    private Boolean boo;

    private BigDecimal bigDecimal; // 精确
    private BigInteger bigInteger; // 大数
    private Date date;
    private java.sql.Date sqlDate;
    private Timestamp timestamp;
    private Calendar calendar;
    private Iterable<?> iterable;
    private Map<?, ?> map;
    private String str;
    private XMLGregorianCalendar xmlGregorianCalendar; // 日期
    private Currency currency; // 货币
    private Locale locale; // 地域


}
