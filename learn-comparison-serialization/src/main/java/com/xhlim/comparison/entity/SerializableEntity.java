package com.xhlim.comparison.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xhlim on 2017/7/6.
 */
@Data
public class SerializableEntity implements Serializable {

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
    protected Boolean boo;


}
