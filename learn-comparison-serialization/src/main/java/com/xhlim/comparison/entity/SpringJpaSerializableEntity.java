package com.xhlim.comparison.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 * Created by xhlim on 2017/7/7.
 */
public class SpringJpaSerializableEntity extends SerializableEntity {

    private Page page;
    private Sort sort;

}
