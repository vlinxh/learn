package com.xhlim.jdk18;

import java.lang.annotation.*;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-13 14:37
 */
public class RepeatingAnnotations {


    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {

    }


}
